#include <iostream>
#include <libusb.h>
#include "cv.h"
#include "highgui.h"

#define FIFO_VID	0x04b4
#define FIFO_PID	0x1004

#define READ_SIZE	512

#define IMAGE_WIDTH 320
#define IMAGE_HEIGHT 240


using namespace std;

unsigned char from_fifo[((IMAGE_WIDTH ) * IMAGE_HEIGHT)+ 10];
unsigned char image_buffer[((IMAGE_WIDTH ) * IMAGE_HEIGHT) + 10];

unsigned char to_fifo[] = { 'a', 'b', 'c', 'd' };

int main() {
	int i, copied_size, remaining ;
	cv::Mat gray_image(IMAGE_HEIGHT, IMAGE_WIDTH , CV_8UC1);
	libusb_device **devs; //pointer to pointer of device, used to retrieve a list of devices
	libusb_device_handle *dev_handle; //a device handle
	libusb_context *ctx = NULL; //a libusb session
	int r; //for return values
	ssize_t cnt; //holding number of devices in list
	r = libusb_init(&ctx); //initialize the library for the session we just declared
	if (r < 0) {
		cout << "Init Error " << r << endl; //there was an error
		return 1;
	}
	libusb_set_debug(ctx, 3); //set verbosity level to 3, as suggested in the documentation

	cnt = libusb_get_device_list(ctx, &devs); //get the list of devices
	if (cnt < 0) {
		cout << "Get Device Error" << endl; //there was an error
		return 1;
	}
	cout << cnt << " Devices in list." << endl;

	dev_handle = libusb_open_device_with_vid_pid(ctx, FIFO_VID, FIFO_PID); //these are vendorID and productID I found for my usb device
	if (dev_handle == NULL)
		cout << "Cannot open device" << endl;
	else
		cout << "Device Opened" << endl;
	libusb_free_device_list(devs, 1); //free the list, unref the devices in it

	int actual; //used to find out how many bytes were written
	if (libusb_kernel_driver_active(dev_handle, 0) == 1) { //find out if kernel driver is attached
		cout << "Kernel Driver Active" << endl;
		if (libusb_detach_kernel_driver(dev_handle, 0) == 0) //detach it
			cout << "Kernel Driver Detached!" << endl;
	}
	r = libusb_claim_interface(dev_handle, 0); //claim interface 0 (the first) of device (mine had jsut 1)
	if (r < 0) {
		cout << "Cannot Claim Interface" << endl;
		return 1;
	}
	cout << "Claimed Interface" << endl;

	cout << "Writing to FIFO..." << endl;

	r = libusb_bulk_transfer(dev_handle, (2 | LIBUSB_ENDPOINT_OUT), to_fifo, 4,
			&actual, 0); //my device's out endpoint was 2, found with trial- the device had 2 endpoints: 2 and 129
	cout << "R : " << r << " nb =" << actual << endl;
	if (r == 0 && actual == 4) //we wrote the 4 bytes successfully
		cout << "Writing Successful!" << endl;
	else
		cout << "Read Error" << endl;

	cout << "Reading from FIFO..." << endl;
	i = 0 ;
	r = libusb_bulk_transfer(dev_handle, (6 | LIBUSB_ENDPOINT_IN), from_fifo,
					(IMAGE_WIDTH * IMAGE_HEIGHT), &actual, 0); //my device's out endpoint was 2, found with trial- the device had 2 endpoints: 2 and 129
	while(1){
		while(from_fifo[i] != 0xA5 && i < IMAGE_WIDTH * IMAGE_HEIGHT){
			i ++ ;
		}
		if(i < IMAGE_WIDTH * IMAGE_HEIGHT){
			//cout << "vsync_found" << endl ;
		}else{
			//cout << "vsync not found" << endl ;
			i = 0 ;
			r = libusb_bulk_transfer(dev_handle, (6 | LIBUSB_ENDPOINT_IN), from_fifo,
								(IMAGE_WIDTH * IMAGE_HEIGHT), &actual, 0); //my device's out endpoint was 2, found with trial- the device had 2 endpoints: 2 and 129
			continue ;
		}
		copied_size = (actual - i );
		//cout << "src index :" << i+1 << endl;
		memcpy(image_buffer, &from_fifo[i+1],  copied_size);
		remaining = i ;
		if(i != 0){
			r = libusb_bulk_transfer(dev_handle, (6 | LIBUSB_ENDPOINT_IN), from_fifo,
					(IMAGE_WIDTH * IMAGE_HEIGHT), &actual, 0); //my device's out endpoint was 2, found with trial- the device had 2 endpoints: 2 and 129
			//cout << "dst index :" << copied_size << " copying  nb :"<< i << "received "<< actual << endl;
			memcpy(&image_buffer[copied_size], from_fifo,  i);
		}
		gray_image.data = image_buffer;
		gray_image.step = IMAGE_WIDTH ;
		cv::imshow("image", gray_image);
		cv::waitKey(2);
	}
	r = libusb_release_interface(dev_handle, 0); //release the claimed interface
	if (r != 0) {
		cout << "Cannot Release Interface" << endl;
		return 1;
	}
	cout << "Released Interface" << endl;

	libusb_close(dev_handle); //close the device we opened
	libusb_exit(ctx); //needs to be called to end the



	gray_image.data = image_buffer;
	gray_image.step = IMAGE_WIDTH;
	cv::imshow("image", gray_image);
	cv::waitKey(0);

	return 0;
}
