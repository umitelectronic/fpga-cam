import fcntl, os, time, mmap, struct


RESETA_INDEX = 12
RESETB_INDEX = 10
SIZE_INDEX = 8
AVAILABLE_INDEX = 12
FREE_INDEX = 10
LATCH_INDEX = 16
GPMC_OFFSET = 0x09000000

sha_test = [0x22, 0x8e, 0xa4, 0X73, 0x2a, 0x3c, 0x9b, 0xa8, 0x60, 0xc0, 0x09, 0xcd, 0xa7, 0x25, 0x2b, 0x91, 0x61, 0xa5, 0xe7, 0x5e, 0xc8, 0xc5, 0x82, 0xa5, 0xf1, 0x06, 0xab, 0xb3, 0xaf, 0x41, 0xf7, 0x90]
sha_data = [0x21, 0x94, 0x26, 0x1a, 0x93, 0x95, 0xe6, 0x4d, 0xbe, 0xd1, 0x71, 0x15]


class Logibone:
	
	def __init__(self):
		if os.path.exists('/dev/logibone0'):
    			self.file = open('/dev/logibone0', 'r+')
		else:
			self.file = -1
			MAP_MASK = mmap.PAGESIZE - 1
			with open("/dev/mem", "r+b" ) as self.mem:
				self.gpmc = mmap.mmap(self.mem.fileno(), mmap.PAGESIZE, offset=GPMC_OFFSET)		
	def read(self, nbBytes):
		if self.file > 0 :
			return self.file.read(nbBytes)
		else:
			available = self.getAvailable()		
			while available < nbBytes/2 :
				available = self.getAvailable()	
				print available
				time.sleep(0.001)
			for i in range(nbBytes/2):
				result.extend(struct.unpack("B", self.gpmc[0:2]))
			return result

	def write(self, val):
		if self.file > 0 :
			return self.file.write(val)
		else:
			print 'writing '+str(len(val))+' bytes'
			free = self.getFree()	
			while free < len(val)/2 :
				free = self.getFree()	
				print free
				time.sleep(0.001)
			for i in range(0, len(val), 2):
				longVal = val[i]+val[i+1]*16
				self.gpmc[0:2] = struct.pack("<H", longVal)

	def reset(self):
		if self.file > 0 :
			fcntl.ioctl(self.file, 0)
		else:
			self.gpmc[RESETA_INDEX:RESETA_INDEX+2] = struct.pack("<H", 0)
			self.gpmc[RESETB_INDEX:RESETB_INDEX+2] = struct.pack("<H", 0)
	def getSize(self):
			ret = struct.unpack("<H",self.gpmc[SIZE_INDEX:SIZE_INDEX+2])
			return ret[0]

	def getFree(self):
		ret = struct.unpack("<H", self.gpmc[FREE_INDEX:FREE_INDEX+2])	
		return (self.getSize()- ret[0])

	def getAvailable(self):
		ret = struct.unpack("<H", self.gpmc[AVAILABLE_INDEX:AVAILABLE_INDEX+2])	
		return ret[0]

	def readState(self):
		ret = struct.unpack("<H", self.gpmc[LATCH_INDEX:LATCH_INDEX+2])	
		return ret[0]

	def close(self):
		if self.file > 0 :
			self.file.close();		
		else:
			self.gpmc.close()
			os.close(self.mem)

if __name__ == "__main__":
	bone = Logibone()
	try:
		bone.reset()		
		print bone.getSize()
		print bone.getFree()
		sha_test.reverse()
		sha_data.reverse()
		bone.write(sha_test)
		time.sleep(2)
		bone.write(sha_data)
		while bone.getAvailable() == 0:
			print bone.getAvailable()
			print bone.readState()
			time.sleep(1)
	except KeyboardInterrupt:
		print("Terminated by Ctrl+C")
		exit(0)

