/**********************************************************************/
/*   ____  ____                                                       */
/*  /   /\/   /                                                       */
/* /___/  \  /                                                        */
/* \   \   \/                                                       */
/*  \   \        Copyright (c) 2003-2009 Xilinx, Inc.                */
/*  /   /          All Right Reserved.                                 */
/* /---/   /\                                                         */
/* \   \  /  \                                                      */
/*  \___\/\___\                                                    */
/***********************************************************************/

/* This file is designed for use with ISim build 0x7708f090 */

#define XSI_HIDE_SYMBOL_SPEC true
#include "xsi.h"
#include <memory.h>
#ifdef __GNUC__
#include <stdlib.h>
#else
#include <malloc.h>
#define alloca _alloca
#endif
static const char *ng0 = "C:/Users/bwiec/Documents/cert_projects/rpi/spi2wishbone/tb/spi2wishbone_tb.vhd";
extern char *IEEE_P_2592010699;

unsigned char ieee_p_2592010699_sub_1744673427_503743352(char *, char *, unsigned int , unsigned int );


static void work_a_2819059617_2372691052_p_0(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    int64 t7;
    int64 t8;

LAB0:    t1 = (t0 + 5632U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(135, ng0);
    t2 = (t0 + 7304);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)2;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(136, ng0);
    t2 = (t0 + 3688U);
    t3 = *((char **)t2);
    t7 = *((int64 *)t3);
    t8 = (t7 / 2);
    t2 = (t0 + 5440);
    xsi_process_wait(t2, t8);

LAB6:    *((char **)t1) = &&LAB7;

LAB1:    return;
LAB4:    xsi_set_current_line(137, ng0);
    t2 = (t0 + 7304);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)3;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(138, ng0);
    t2 = (t0 + 3688U);
    t3 = *((char **)t2);
    t7 = *((int64 *)t3);
    t8 = (t7 / 2);
    t2 = (t0 + 5440);
    xsi_process_wait(t2, t8);

LAB10:    *((char **)t1) = &&LAB11;
    goto LAB1;

LAB5:    goto LAB4;

LAB7:    goto LAB5;

LAB8:    goto LAB2;

LAB9:    goto LAB8;

LAB11:    goto LAB9;

}

static void work_a_2819059617_2372691052_p_1(char *t0)
{
    char *t1;
    char *t2;
    int64 t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;

LAB0:    t1 = (t0 + 5880U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(144, ng0);
    t3 = (100 * 1000LL);
    t2 = (t0 + 5688);
    xsi_process_wait(t2, t3);

LAB6:    *((char **)t1) = &&LAB7;

LAB1:    return;
LAB4:    xsi_set_current_line(145, ng0);
    t2 = (t0 + 7368);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = (unsigned char)2;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(146, ng0);

LAB10:    *((char **)t1) = &&LAB11;
    goto LAB1;

LAB5:    goto LAB4;

LAB7:    goto LAB5;

LAB8:    goto LAB2;

LAB9:    goto LAB8;

LAB11:    goto LAB9;

}

static void work_a_2819059617_2372691052_p_2(char *t0)
{
    char *t1;
    char *t2;
    int64 t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    int64 t8;
    int t9;
    int t10;
    int t11;
    int t12;
    char *t13;
    char *t14;
    char *t15;
    int t16;
    int t17;
    int t18;
    int t19;
    int t20;
    int t21;
    int t22;
    unsigned int t23;
    unsigned int t24;
    int t25;
    int t26;
    unsigned int t27;
    unsigned int t28;
    unsigned int t29;
    unsigned int t30;
    unsigned char t31;
    char *t32;
    char *t33;
    char *t34;

LAB0:    t1 = (t0 + 6128U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(153, ng0);
    t3 = (200 * 1000LL);
    t2 = (t0 + 5936);
    xsi_process_wait(t2, t3);

LAB6:    *((char **)t1) = &&LAB7;

LAB1:    return;
LAB4:    xsi_set_current_line(154, ng0);
    t2 = (t0 + 7432);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = (unsigned char)3;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(155, ng0);
    t2 = (t0 + 3568U);
    t4 = *((char **)t2);
    t3 = *((int64 *)t4);
    t8 = (t3 / 2);
    t2 = (t0 + 5936);
    xsi_process_wait(t2, t8);

LAB10:    *((char **)t1) = &&LAB11;
    goto LAB1;

LAB5:    goto LAB4;

LAB7:    goto LAB5;

LAB8:    xsi_set_current_line(156, ng0);
    t2 = (t0 + 3808U);
    t4 = *((char **)t2);
    t9 = *((int *)t4);
    t10 = (t9 - 1);
    t2 = (t0 + 13349);
    *((int *)t2) = 0;
    t5 = (t0 + 13353);
    *((int *)t5) = t10;
    t11 = 0;
    t12 = t10;

LAB12:    if (t11 <= t12)
        goto LAB13;

LAB15:    goto LAB2;

LAB9:    goto LAB8;

LAB11:    goto LAB9;

LAB13:    xsi_set_current_line(157, ng0);
    t6 = (t0 + 7496);
    t7 = (t6 + 56U);
    t13 = *((char **)t7);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    *((unsigned char *)t15) = (unsigned char)2;
    xsi_driver_first_trans_fast(t6);
    xsi_set_current_line(158, ng0);
    t2 = (t0 + 4048U);
    t4 = *((char **)t2);
    t9 = *((int *)t4);
    t10 = (t9 - 1);
    t2 = (t0 + 13357);
    *((int *)t2) = 0;
    t5 = (t0 + 13361);
    *((int *)t5) = t10;
    t16 = 0;
    t17 = t10;

LAB16:    if (t16 <= t17)
        goto LAB17;

LAB19:    xsi_set_current_line(165, ng0);
    t2 = (t0 + 7496);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = (unsigned char)3;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(166, ng0);
    t2 = (t0 + 3568U);
    t4 = *((char **)t2);
    t3 = *((int64 *)t4);
    t8 = (t3 * 5);
    t2 = (t0 + 5936);
    xsi_process_wait(t2, t8);

LAB31:    *((char **)t1) = &&LAB32;
    goto LAB1;

LAB14:    t2 = (t0 + 13349);
    t11 = *((int *)t2);
    t4 = (t0 + 13353);
    t12 = *((int *)t4);
    if (t11 == t12)
        goto LAB15;

LAB33:    t9 = (t11 + 1);
    t11 = t9;
    t5 = (t0 + 13349);
    *((int *)t5) = t11;
    goto LAB12;

LAB17:    xsi_set_current_line(159, ng0);
    t6 = (t0 + 3568U);
    t7 = *((char **)t6);
    t3 = *((int64 *)t7);
    t8 = (t3 / 2);
    t6 = (t0 + 5936);
    xsi_process_wait(t6, t8);

LAB22:    *((char **)t1) = &&LAB23;
    goto LAB1;

LAB18:    t2 = (t0 + 13357);
    t16 = *((int *)t2);
    t4 = (t0 + 13361);
    t17 = *((int *)t4);
    if (t16 == t17)
        goto LAB19;

LAB28:    t9 = (t16 + 1);
    t16 = t9;
    t5 = (t0 + 13357);
    *((int *)t5) = t16;
    goto LAB16;

LAB20:    xsi_set_current_line(160, ng0);
    t2 = (t0 + 7432);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = (unsigned char)2;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(161, ng0);
    t2 = (t0 + 4648U);
    t4 = *((char **)t2);
    t2 = (t0 + 4048U);
    t5 = *((char **)t2);
    t9 = *((int *)t5);
    t10 = (t9 - 1);
    t2 = (t0 + 13357);
    t18 = *((int *)t2);
    t19 = (t10 - t18);
    t6 = (t0 + 4048U);
    t7 = *((char **)t6);
    t20 = *((int *)t7);
    t21 = (t20 - 1);
    t22 = (t19 - t21);
    t23 = (t22 * -1);
    xsi_vhdl_check_range_of_index(t21, 0, -1, t19);
    t24 = (1U * t23);
    t6 = (t0 + 13349);
    t25 = *((int *)t6);
    t26 = (t25 - 0);
    t27 = (t26 * 1);
    xsi_vhdl_check_range_of_index(0, 15, 1, *((int *)t6));
    t28 = (32U * t27);
    t29 = (0 + t28);
    t30 = (t29 + t24);
    t13 = (t4 + t30);
    t31 = *((unsigned char *)t13);
    t14 = (t0 + 7560);
    t15 = (t14 + 56U);
    t32 = *((char **)t15);
    t33 = (t32 + 56U);
    t34 = *((char **)t33);
    *((unsigned char *)t34) = t31;
    xsi_driver_first_trans_fast(t14);
    xsi_set_current_line(162, ng0);
    t2 = (t0 + 3568U);
    t4 = *((char **)t2);
    t3 = *((int64 *)t4);
    t8 = (t3 / 2);
    t2 = (t0 + 5936);
    xsi_process_wait(t2, t8);

LAB26:    *((char **)t1) = &&LAB27;
    goto LAB1;

LAB21:    goto LAB20;

LAB23:    goto LAB21;

LAB24:    xsi_set_current_line(163, ng0);
    t2 = (t0 + 7432);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = (unsigned char)3;
    xsi_driver_first_trans_fast(t2);
    goto LAB18;

LAB25:    goto LAB24;

LAB27:    goto LAB25;

LAB29:    goto LAB14;

LAB30:    goto LAB29;

LAB32:    goto LAB30;

}

static void work_a_2819059617_2372691052_p_3(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    int t4;
    int t5;
    char *t6;
    int t7;
    int t8;
    char *t9;
    char *t10;
    char *t11;
    unsigned char t12;
    unsigned char t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    char *t17;
    char *t18;

LAB0:    t1 = (t0 + 6376U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(173, ng0);
    t2 = (t0 + 3808U);
    t3 = *((char **)t2);
    t4 = *((int *)t3);
    t5 = (t4 - 1);
    t2 = (t0 + 13365);
    *((int *)t2) = 0;
    t6 = (t0 + 13369);
    *((int *)t6) = t5;
    t7 = 0;
    t8 = t5;

LAB4:    if (t7 <= t8)
        goto LAB5;

LAB7:    xsi_set_current_line(177, ng0);

LAB15:    *((char **)t1) = &&LAB16;

LAB1:    return;
LAB5:    xsi_set_current_line(174, ng0);

LAB10:    t9 = (t0 + 7192);
    *((int *)t9) = 1;
    *((char **)t1) = &&LAB11;
    goto LAB1;

LAB6:    t2 = (t0 + 13365);
    t7 = *((int *)t2);
    t3 = (t0 + 13369);
    t8 = *((int *)t3);
    if (t7 == t8)
        goto LAB7;

LAB12:    t4 = (t7 + 1);
    t7 = t4;
    t6 = (t0 + 13365);
    *((int *)t6) = t7;
    goto LAB4;

LAB8:    t10 = (t0 + 7192);
    *((int *)t10) = 0;
    xsi_set_current_line(175, ng0);
    t2 = (t0 + 4648U);
    t3 = *((char **)t2);
    t2 = (t0 + 13365);
    t4 = *((int *)t2);
    t5 = (t4 - 0);
    t14 = (t5 * 1);
    xsi_vhdl_check_range_of_index(0, 15, 1, *((int *)t2));
    t15 = (32U * t14);
    t16 = (0 + t15);
    t6 = (t3 + t16);
    t9 = (t0 + 7624);
    t10 = (t9 + 56U);
    t11 = *((char **)t10);
    t17 = (t11 + 56U);
    t18 = *((char **)t17);
    memcpy(t18, t6, 32U);
    xsi_driver_first_trans_fast(t9);
    goto LAB6;

LAB9:    t10 = (t0 + 2792U);
    t11 = *((char **)t10);
    t12 = *((unsigned char *)t11);
    t13 = (t12 == (unsigned char)3);
    if (t13 == 1)
        goto LAB8;
    else
        goto LAB10;

LAB11:    goto LAB9;

LAB13:    goto LAB2;

LAB14:    goto LAB13;

LAB16:    goto LAB14;

}

static void work_a_2819059617_2372691052_p_4(char *t0)
{
    char *t1;
    char *t2;
    int64 t3;
    char *t4;
    unsigned char t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;

LAB0:    xsi_set_current_line(181, ng0);

LAB3:    t1 = (t0 + 3928U);
    t2 = *((char **)t1);
    t3 = *((int64 *)t2);
    t1 = (t0 + 1352U);
    t4 = *((char **)t1);
    t5 = *((unsigned char *)t4);
    t1 = (t0 + 7688);
    t6 = (t1 + 56U);
    t7 = *((char **)t6);
    t8 = (t7 + 56U);
    t9 = *((char **)t8);
    *((unsigned char *)t9) = t5;
    xsi_driver_first_trans_delta(t1, 0U, 1, t3);

LAB2:    t10 = (t0 + 7208);
    *((int *)t10) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2819059617_2372691052_p_5(char *t0)
{
    char *t1;
    unsigned char t2;
    char *t3;
    char *t4;
    unsigned char t5;
    char *t6;
    unsigned char t7;
    unsigned char t8;

LAB0:    xsi_set_current_line(185, ng0);
    t1 = (t0 + 992U);
    t2 = ieee_p_2592010699_sub_1744673427_503743352(IEEE_P_2592010699, t1, 0U, 0U);
    if (t2 != 0)
        goto LAB2;

LAB4:
LAB3:    t1 = (t0 + 7224);
    *((int *)t1) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(186, ng0);
    t3 = (t0 + 3272U);
    t4 = *((char **)t3);
    t5 = *((unsigned char *)t4);
    t3 = (t0 + 2152U);
    t6 = *((char **)t3);
    t7 = *((unsigned char *)t6);
    t8 = (t5 == t7);
    if (t8 == 0)
        goto LAB5;

LAB6:    goto LAB3;

LAB5:    t3 = (t0 + 13373);
    xsi_report(t3, 20U, (unsigned char)1);
    goto LAB6;

}


extern void work_a_2819059617_2372691052_init()
{
	static char *pe[] = {(void *)work_a_2819059617_2372691052_p_0,(void *)work_a_2819059617_2372691052_p_1,(void *)work_a_2819059617_2372691052_p_2,(void *)work_a_2819059617_2372691052_p_3,(void *)work_a_2819059617_2372691052_p_4,(void *)work_a_2819059617_2372691052_p_5};
	xsi_register_didat("work_a_2819059617_2372691052", "isim/spi2wishbone_tb_isim_beh.exe.sim/work/a_2819059617_2372691052.didat");
	xsi_register_executes(pe);
}
