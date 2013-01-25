import fcntl, os, time


RESETA_INDEX = 12
RESETB_INDEX = 10
AVAILABLE_INDEX = 12
FREE_INDEX = 10

class Logibone:
	
	def __init__(self):
		if os.path.exists('/dev/logibone0'):
    			self.file = open('/dev/logibone0', 'r+')
			return self.file
		else:
			self.file = -1
			MAP_MASK = mmap.PAGESIZE - 1
			self.addr = 0x09000000
			self.mem = os.open("/dev/mem", os.O_RDWR | os.O_SYNC)
			self.gpmc = mmap.mmap(self.mem, mmap.PAGESIZE, mmap.MAP_SHARED, mmap.PROT_WRITE | mmap.PROT_READ, addr)
			return self.gpmc
	def read(self, nbBytes):
		if self.file > 0 :
			return self.file.read(nbBytes)
		else:
			available = struct.unpack("<H", mem[AVAILABLE_INDEX:AVAILABLE_INDEX+2])		
			while available < nbBytes/2 :
				available = struct.unpack("<H", mem[AVAILABLE_INDEX:AVAILABLE_INDEX+2])
				print available
				time.sleep(0.001)
			for i in range(nbBytes/2):
				result.append(struct.unpack("B", mem[0:2]))
			return result

	def write(self, val):
		if self.file > 0 :
			return self.file.write(val)
		else:
			free = struct.unpack("<H", mem[FREE_INDEX:FREE_INDEX+2])		
			while free < len(val)/2 :
				free = struct.unpack("<H", mem[FREE_INDEX:FREE_INDEX+2])
				print free
				time.sleep(0.001)
			for i in range(len(val)/2):
				mem[0:2] = struct.pack("B", val[i:i+2])

	def reset(self):
		if self.file > 0 :
			fcntl.ioctl(self.file, 0)
		else:
			mem[RESETA_INDEX:RESETA_INDEX+2] = struct.pack("<H", 0)
			mem[RESETA_INDEX:RESETB_INDEX+2] = struct.pack("<H", 0)

	def close(self):
		if self.file > 0 :
			self.file.close();		
		else:
			self.gpmc.close()
			os.close(self.mem)



