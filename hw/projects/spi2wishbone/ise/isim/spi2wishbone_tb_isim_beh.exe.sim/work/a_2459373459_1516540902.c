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
static const char *ng0 = "C:/Users/bwiec/Documents/cert_projects/rpi/spi2wishbone/src/spi_slave.vhd";
extern char *IEEE_P_2592010699;
extern char *IEEE_P_1242562249;

char *ieee_p_1242562249_sub_180853171_1035706684(char *, char *, int , int );
unsigned char ieee_p_2592010699_sub_1605435078_503743352(char *, unsigned char , unsigned char );
unsigned char ieee_p_2592010699_sub_1690584930_503743352(char *, unsigned char );


static void work_a_2459373459_1516540902_p_0(char *t0)
{
    unsigned char t1;
    char *t2;

LAB0:    xsi_set_current_line(242, ng0);
    t1 = (32 >= 8);
    if (t1 == 0)
        goto LAB2;

LAB3:
LAB1:    return;
LAB2:    t2 = (t0 + 25567);
    xsi_report(t2, 79U, (unsigned char)3);
    goto LAB3;

}

static void work_a_2459373459_1516540902_p_1(char *t0)
{
    int t1;
    unsigned char t2;
    char *t3;

LAB0:    xsi_set_current_line(246, ng0);
    t1 = (32 - 5);
    t2 = (3 <= t1);
    if (t2 == 0)
        goto LAB2;

LAB3:
LAB1:    return;
LAB2:    t3 = (t0 + 25646);
    xsi_report(t3, 89U, (unsigned char)3);
    goto LAB3;

}

static void work_a_2459373459_1516540902_p_2(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;

LAB0:    xsi_set_current_line(258, ng0);

LAB3:    t1 = (t0 + 1512U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 14704);
    t4 = (t1 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = t3;
    xsi_driver_first_trans_fast(t1);

LAB2:    t8 = (t0 + 14400);
    *((int *)t8) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2459373459_1516540902_p_3(char *t0)
{
    unsigned char t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    unsigned char t6;
    unsigned char t7;
    char *t8;
    unsigned char t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;
    unsigned char t14;

LAB0:    xsi_set_current_line(270, ng0);
    t2 = (t0 + 992U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:
LAB3:    xsi_set_current_line(286, ng0);
    t2 = (t0 + 6632U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 6792U);
    t5 = *((char **)t2);
    t3 = *((unsigned char *)t5);
    t6 = ieee_p_2592010699_sub_1605435078_503743352(IEEE_P_2592010699, t1, t3);
    t2 = (t0 + 7112U);
    t8 = *((char **)t2);
    t7 = *((unsigned char *)t8);
    t9 = ieee_p_2592010699_sub_1690584930_503743352(IEEE_P_2592010699, t7);
    t14 = ieee_p_2592010699_sub_1605435078_503743352(IEEE_P_2592010699, t6, t9);
    t2 = (t0 + 15408);
    t10 = (t2 + 56U);
    t11 = *((char **)t10);
    t12 = (t11 + 56U);
    t13 = *((char **)t12);
    *((unsigned char *)t13) = t14;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(287, ng0);
    t2 = (t0 + 7592U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 7752U);
    t5 = *((char **)t2);
    t3 = *((unsigned char *)t5);
    t6 = ieee_p_2592010699_sub_1605435078_503743352(IEEE_P_2592010699, t1, t3);
    t2 = (t0 + 8072U);
    t8 = *((char **)t2);
    t7 = *((unsigned char *)t8);
    t9 = ieee_p_2592010699_sub_1690584930_503743352(IEEE_P_2592010699, t7);
    t14 = ieee_p_2592010699_sub_1605435078_503743352(IEEE_P_2592010699, t6, t9);
    t2 = (t0 + 15472);
    t10 = (t2 + 56U);
    t11 = *((char **)t10);
    t12 = (t11 + 56U);
    t13 = *((char **)t12);
    *((unsigned char *)t13) = t14;
    xsi_driver_first_trans_fast(t2);
    t2 = (t0 + 14416);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(272, ng0);
    t4 = (t0 + 5992U);
    t8 = *((char **)t4);
    t9 = *((unsigned char *)t8);
    t4 = (t0 + 14768);
    t10 = (t4 + 56U);
    t11 = *((char **)t10);
    t12 = (t11 + 56U);
    t13 = *((char **)t12);
    *((unsigned char *)t13) = t9;
    xsi_driver_first_trans_fast(t4);
    xsi_set_current_line(273, ng0);
    t2 = (t0 + 6632U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 14832);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t10 = (t8 + 56U);
    t11 = *((char **)t10);
    *((unsigned char *)t11) = t1;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(274, ng0);
    t2 = (t0 + 6792U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 14896);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t10 = (t8 + 56U);
    t11 = *((char **)t10);
    *((unsigned char *)t11) = t1;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(275, ng0);
    t2 = (t0 + 6952U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 14960);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t10 = (t8 + 56U);
    t11 = *((char **)t10);
    *((unsigned char *)t11) = t1;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(276, ng0);
    t2 = (t0 + 6472U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 15024);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t10 = (t8 + 56U);
    t11 = *((char **)t10);
    *((unsigned char *)t11) = t1;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(279, ng0);
    t2 = (t0 + 6312U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 15088);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t10 = (t8 + 56U);
    t11 = *((char **)t10);
    *((unsigned char *)t11) = t1;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(280, ng0);
    t2 = (t0 + 7592U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 15152);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t10 = (t8 + 56U);
    t11 = *((char **)t10);
    *((unsigned char *)t11) = t1;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(281, ng0);
    t2 = (t0 + 7752U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 15216);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t10 = (t8 + 56U);
    t11 = *((char **)t10);
    *((unsigned char *)t11) = t1;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(282, ng0);
    t2 = (t0 + 7912U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 15280);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t10 = (t8 + 56U);
    t11 = *((char **)t10);
    *((unsigned char *)t11) = t1;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(283, ng0);
    t2 = (t0 + 7432U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t2 = (t0 + 15344);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t10 = (t8 + 56U);
    t11 = *((char **)t10);
    *((unsigned char *)t11) = t1;
    xsi_driver_first_trans_fast(t2);
    goto LAB3;

LAB5:    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB7;

}

static void work_a_2459373459_1516540902_p_4(char *t0)
{
    unsigned char t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    unsigned char t6;
    unsigned char t7;
    char *t8;
    unsigned char t9;
    unsigned char t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;

LAB0:    xsi_set_current_line(293, ng0);
    t2 = (t0 + 992U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:
LAB3:    xsi_set_current_line(299, ng0);
    t2 = (t0 + 992U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB14;

LAB15:    t1 = (unsigned char)0;

LAB16:    if (t1 != 0)
        goto LAB11;

LAB13:
LAB12:    t2 = (t0 + 14432);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(294, ng0);
    t4 = (t0 + 2152U);
    t8 = *((char **)t4);
    t9 = *((unsigned char *)t8);
    t10 = (t9 == (unsigned char)3);
    if (t10 != 0)
        goto LAB8;

LAB10:
LAB9:    goto LAB3;

LAB5:    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB7;

LAB8:    xsi_set_current_line(295, ng0);
    t4 = (t0 + 1992U);
    t11 = *((char **)t4);
    t4 = (t0 + 15536);
    t12 = (t4 + 56U);
    t13 = *((char **)t12);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    memcpy(t15, t11, 32U);
    xsi_driver_first_trans_fast(t4);
    goto LAB9;

LAB11:    xsi_set_current_line(300, ng0);
    t4 = (t0 + 2152U);
    t8 = *((char **)t4);
    t9 = *((unsigned char *)t8);
    t10 = (t9 == (unsigned char)3);
    if (t10 != 0)
        goto LAB17;

LAB19:    t2 = (t0 + 5352U);
    t4 = *((char **)t2);
    t1 = *((unsigned char *)t4);
    t3 = (t1 == (unsigned char)3);
    if (t3 != 0)
        goto LAB20;

LAB21:
LAB18:    goto LAB12;

LAB14:    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB16;

LAB17:    xsi_set_current_line(301, ng0);
    t4 = (t0 + 15600);
    t11 = (t4 + 56U);
    t12 = *((char **)t11);
    t13 = (t12 + 56U);
    t14 = *((char **)t13);
    *((unsigned char *)t14) = (unsigned char)3;
    xsi_driver_first_trans_fast(t4);
    goto LAB18;

LAB20:    xsi_set_current_line(303, ng0);
    t2 = (t0 + 15600);
    t5 = (t2 + 56U);
    t8 = *((char **)t5);
    t11 = (t8 + 56U);
    t12 = *((char **)t11);
    *((unsigned char *)t12) = (unsigned char)2;
    xsi_driver_first_trans_fast(t2);
    goto LAB18;

}

static void work_a_2459373459_1516540902_p_5(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    unsigned char t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    unsigned char t9;
    unsigned char t10;
    unsigned char t11;
    int t12;
    char *t13;
    char *t14;
    char *t15;
    unsigned char t16;

LAB0:    xsi_set_current_line(316, ng0);
    t1 = (t0 + 1192U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t4 = (t3 == (unsigned char)3);
    if (t4 != 0)
        goto LAB2;

LAB4:    t1 = (t0 + 1312U);
    t4 = xsi_signal_has_event(t1);
    if (t4 == 1)
        goto LAB7;

LAB8:    t3 = (unsigned char)0;

LAB9:    if (t3 != 0)
        goto LAB5;

LAB6:
LAB3:    xsi_set_current_line(323, ng0);
    t1 = (t0 + 1312U);
    t4 = xsi_signal_has_event(t1);
    if (t4 == 1)
        goto LAB13;

LAB14:    t3 = (unsigned char)0;

LAB15:    if (t3 != 0)
        goto LAB10;

LAB12:
LAB11:    xsi_set_current_line(332, ng0);
    t1 = (t0 + 1192U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t4 = (t3 == (unsigned char)3);
    if (t4 != 0)
        goto LAB16;

LAB18:    t1 = (t0 + 1312U);
    t4 = xsi_signal_has_event(t1);
    if (t4 == 1)
        goto LAB21;

LAB22:    t3 = (unsigned char)0;

LAB23:    if (t3 != 0)
        goto LAB19;

LAB20:
LAB17:    xsi_set_current_line(339, ng0);
    t1 = (t0 + 1312U);
    t4 = xsi_signal_has_event(t1);
    if (t4 == 1)
        goto LAB27;

LAB28:    t3 = (unsigned char)0;

LAB29:    if (t3 != 0)
        goto LAB24;

LAB26:
LAB25:    t1 = (t0 + 14448);
    *((int *)t1) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(317, ng0);
    t1 = (t0 + 15664);
    t5 = (t1 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    *((int *)t8) = 0;
    xsi_driver_first_trans_fast(t1);
    goto LAB3;

LAB5:    xsi_set_current_line(319, ng0);
    t2 = (t0 + 3592U);
    t7 = *((char **)t2);
    t12 = *((int *)t7);
    t2 = (t0 + 15664);
    t8 = (t2 + 56U);
    t13 = *((char **)t8);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    *((int *)t15) = t12;
    xsi_driver_first_trans_fast(t2);
    goto LAB3;

LAB7:    t2 = (t0 + 1352U);
    t5 = *((char **)t2);
    t9 = *((unsigned char *)t5);
    t2 = (t0 + 9008U);
    t6 = *((char **)t2);
    t10 = *((unsigned char *)t6);
    t11 = (t9 == t10);
    t3 = t11;
    goto LAB9;

LAB10:    xsi_set_current_line(324, ng0);
    t2 = (t0 + 3912U);
    t7 = *((char **)t2);
    t2 = (t0 + 15728);
    t8 = (t2 + 56U);
    t13 = *((char **)t8);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    memcpy(t15, t7, 32U);
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(325, ng0);
    t1 = (t0 + 5512U);
    t2 = *((char **)t1);
    t1 = (t0 + 15792);
    t5 = (t1 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t2, 32U);
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(326, ng0);
    t1 = (t0 + 5832U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 15856);
    t5 = (t1 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    *((unsigned char *)t8) = t3;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(327, ng0);
    t1 = (t0 + 6152U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 15920);
    t5 = (t1 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    *((unsigned char *)t8) = t3;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(328, ng0);
    t1 = (t0 + 5192U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 15984);
    t5 = (t1 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    *((unsigned char *)t8) = t3;
    xsi_driver_first_trans_fast(t1);
    goto LAB11;

LAB13:    t2 = (t0 + 1352U);
    t5 = *((char **)t2);
    t9 = *((unsigned char *)t5);
    t2 = (t0 + 9008U);
    t6 = *((char **)t2);
    t10 = *((unsigned char *)t6);
    t11 = (t9 == t10);
    t3 = t11;
    goto LAB15;

LAB16:    xsi_set_current_line(333, ng0);
    t1 = (t0 + 16048);
    t5 = (t1 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    *((unsigned char *)t8) = (unsigned char)3;
    xsi_driver_first_trans_fast(t1);
    goto LAB17;

LAB19:    xsi_set_current_line(335, ng0);
    t2 = (t0 + 1192U);
    t7 = *((char **)t2);
    t16 = *((unsigned char *)t7);
    t2 = (t0 + 16048);
    t8 = (t2 + 56U);
    t13 = *((char **)t8);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    *((unsigned char *)t15) = t16;
    xsi_driver_first_trans_fast(t2);
    goto LAB17;

LAB21:    t2 = (t0 + 1352U);
    t5 = *((char **)t2);
    t9 = *((unsigned char *)t5);
    t2 = (t0 + 9128U);
    t6 = *((char **)t2);
    t10 = *((unsigned char *)t6);
    t11 = (t9 == t10);
    t3 = t11;
    goto LAB23;

LAB24:    xsi_set_current_line(340, ng0);
    t2 = (t0 + 4392U);
    t7 = *((char **)t2);
    t16 = *((unsigned char *)t7);
    t2 = (t0 + 16112);
    t8 = (t2 + 56U);
    t13 = *((char **)t8);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    *((unsigned char *)t15) = t16;
    xsi_driver_first_trans_fast(t2);
    goto LAB25;

LAB27:    t2 = (t0 + 1352U);
    t5 = *((char **)t2);
    t9 = *((unsigned char *)t5);
    t2 = (t0 + 9128U);
    t6 = *((char **)t2);
    t10 = *((unsigned char *)t6);
    t11 = (t9 == t10);
    t3 = t11;
    goto LAB29;

}

static void work_a_2459373459_1516540902_p_6(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    unsigned char t7;
    int t8;
    int t9;
    int t10;
    int t11;
    unsigned int t12;
    unsigned int t13;
    unsigned int t14;
    char *t15;
    unsigned char t16;

LAB0:    xsi_set_current_line(352, ng0);
    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t1 = (t0 + 16176);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    memcpy(t6, t2, 32U);
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(353, ng0);
    t1 = (t0 + 4552U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16240);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(354, ng0);
    t1 = (t0 + 5672U);
    t2 = *((char **)t1);
    t1 = (t0 + 16304);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    memcpy(t6, t2, 32U);
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(355, ng0);
    t1 = (t0 + 5992U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16368);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(356, ng0);
    t1 = (t0 + 5352U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16432);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(357, ng0);
    t1 = (t0 + 6312U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16496);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(358, ng0);
    t1 = (t0 + 3752U);
    t2 = *((char **)t1);
    t8 = *((int *)t2);
    t1 = (t0 + 16560);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((int *)t6) = t8;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(359, ng0);
    t1 = (t0 + 3752U);
    t2 = *((char **)t1);
    t8 = *((int *)t2);
    if (t8 == 32)
        goto LAB3;

LAB10:    t9 = (3 + 3);
    t10 = (32 - 1);
    if (t8 >= t9)
        goto LAB12;

LAB11:    t11 = (3 + 2);
    if (t8 >= 3)
        goto LAB14;

LAB13:    if (t8 == 2)
        goto LAB6;

LAB15:    if (t8 == 1)
        goto LAB7;

LAB16:    if (t8 == 0)
        goto LAB8;

LAB17:
LAB9:    xsi_set_current_line(420, ng0);
    t1 = (t0 + 16560);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((int *)t5) = 0;
    xsi_driver_first_trans_fast(t1);

LAB2:    t1 = (t0 + 14464);
    *((int *)t1) = 1;

LAB1:    return;
LAB3:    xsi_set_current_line(362, ng0);
    t1 = (t0 + 16432);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(363, ng0);
    t1 = (t0 + 16496);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(364, ng0);
    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t8 = (32 - 1);
    t9 = (t8 - 31);
    t12 = (t9 * -1);
    t13 = (1U * t12);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t7 = *((unsigned char *)t1);
    t3 = (t0 + 16240);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    *((unsigned char *)t15) = t7;
    xsi_driver_first_trans_fast(t3);
    xsi_set_current_line(365, ng0);
    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t8 = (32 - 2);
    t12 = (31 - t8);
    t13 = (t12 * 1U);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t3 = (t0 + 16176);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    memcpy(t15, t1, 31U);
    xsi_driver_first_trans_delta(t3, 0U, 31U, 0LL);
    xsi_set_current_line(366, ng0);
    t1 = (t0 + 4232U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16176);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_delta(t1, 31U, 1, 0LL);
    xsi_set_current_line(367, ng0);
    t1 = (t0 + 3752U);
    t2 = *((char **)t1);
    t8 = *((int *)t2);
    t9 = (t8 - 1);
    t1 = (t0 + 16560);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((int *)t6) = t9;
    xsi_driver_first_trans_fast(t1);
    goto LAB2;

LAB4:    xsi_set_current_line(370, ng0);
    t1 = (t0 + 16368);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(371, ng0);
    t1 = (t0 + 16496);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(372, ng0);
    t1 = (t0 + 16432);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(373, ng0);
    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t8 = (32 - 1);
    t9 = (t8 - 31);
    t12 = (t9 * -1);
    t13 = (1U * t12);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t7 = *((unsigned char *)t1);
    t3 = (t0 + 16240);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    *((unsigned char *)t15) = t7;
    xsi_driver_first_trans_fast(t3);
    xsi_set_current_line(374, ng0);
    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t8 = (32 - 2);
    t12 = (31 - t8);
    t13 = (t12 * 1U);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t3 = (t0 + 16176);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    memcpy(t15, t1, 31U);
    xsi_driver_first_trans_delta(t3, 0U, 31U, 0LL);
    xsi_set_current_line(375, ng0);
    t1 = (t0 + 4232U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16176);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_delta(t1, 31U, 1, 0LL);
    xsi_set_current_line(376, ng0);
    t1 = (t0 + 3752U);
    t2 = *((char **)t1);
    t8 = *((int *)t2);
    t9 = (t8 - 1);
    t1 = (t0 + 16560);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((int *)t6) = t9;
    xsi_driver_first_trans_fast(t1);
    goto LAB2;

LAB5:    xsi_set_current_line(379, ng0);
    t1 = (t0 + 16496);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)3;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(380, ng0);
    t1 = (t0 + 16432);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(381, ng0);
    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t8 = (32 - 1);
    t9 = (t8 - 31);
    t12 = (t9 * -1);
    t13 = (1U * t12);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t7 = *((unsigned char *)t1);
    t3 = (t0 + 16240);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    *((unsigned char *)t15) = t7;
    xsi_driver_first_trans_fast(t3);
    xsi_set_current_line(382, ng0);
    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t8 = (32 - 2);
    t12 = (31 - t8);
    t13 = (t12 * 1U);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t3 = (t0 + 16176);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    memcpy(t15, t1, 31U);
    xsi_driver_first_trans_delta(t3, 0U, 31U, 0LL);
    xsi_set_current_line(383, ng0);
    t1 = (t0 + 4232U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16176);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_delta(t1, 31U, 1, 0LL);
    xsi_set_current_line(384, ng0);
    t1 = (t0 + 3752U);
    t2 = *((char **)t1);
    t8 = *((int *)t2);
    t9 = (t8 - 1);
    t1 = (t0 + 16560);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((int *)t6) = t9;
    xsi_driver_first_trans_fast(t1);
    goto LAB2;

LAB6:    xsi_set_current_line(387, ng0);
    t1 = (t0 + 16496);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)3;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(388, ng0);
    t1 = (t0 + 16432);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(389, ng0);
    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t8 = (32 - 1);
    t9 = (t8 - 31);
    t12 = (t9 * -1);
    t13 = (1U * t12);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t7 = *((unsigned char *)t1);
    t3 = (t0 + 16240);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    *((unsigned char *)t15) = t7;
    xsi_driver_first_trans_fast(t3);
    xsi_set_current_line(390, ng0);
    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t8 = (32 - 2);
    t12 = (31 - t8);
    t13 = (t12 * 1U);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t3 = (t0 + 16176);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    memcpy(t15, t1, 31U);
    xsi_driver_first_trans_delta(t3, 0U, 31U, 0LL);
    xsi_set_current_line(391, ng0);
    t1 = (t0 + 4232U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16176);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_delta(t1, 31U, 1, 0LL);
    xsi_set_current_line(392, ng0);
    t1 = (t0 + 16368);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)3;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(393, ng0);
    t1 = (t0 + 3912U);
    t2 = *((char **)t1);
    t1 = (t0 + 16304);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    memcpy(t6, t2, 32U);
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(394, ng0);
    t1 = (t0 + 3752U);
    t2 = *((char **)t1);
    t8 = *((int *)t2);
    t9 = (t8 - 1);
    t1 = (t0 + 16560);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((int *)t6) = t9;
    xsi_driver_first_trans_fast(t1);
    goto LAB2;

LAB7:    xsi_set_current_line(397, ng0);
    t1 = (t0 + 4232U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16176);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_delta(t1, 31U, 1, 0LL);
    xsi_set_current_line(398, ng0);
    t1 = (t0 + 16496);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(399, ng0);
    t1 = (t0 + 16560);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((int *)t5) = 32;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(400, ng0);
    t1 = (t0 + 5032U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t16 = (t7 == (unsigned char)3);
    if (t16 != 0)
        goto LAB19;

LAB21:    xsi_set_current_line(405, ng0);
    t1 = (t0 + 16432);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(406, ng0);
    t1 = xsi_get_transient_memory(31U);
    memset(t1, 0, 31U);
    t2 = t1;
    memset(t2, (unsigned char)2, 31U);
    t3 = (t0 + 16176);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    memcpy(t15, t1, 31U);
    xsi_driver_first_trans_delta(t3, 0U, 31U, 0LL);
    xsi_set_current_line(407, ng0);
    t1 = (t0 + 16240);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);

LAB20:    goto LAB2;

LAB8:    xsi_set_current_line(411, ng0);
    t1 = (t0 + 4232U);
    t2 = *((char **)t1);
    t7 = *((unsigned char *)t2);
    t1 = (t0 + 16176);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = t7;
    xsi_driver_first_trans_delta(t1, 31U, 1, 0LL);
    xsi_set_current_line(412, ng0);
    t1 = (t0 + 4872U);
    t2 = *((char **)t1);
    t8 = (32 - 2);
    t12 = (31 - t8);
    t13 = (t12 * 1U);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t3 = (t0 + 16176);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    memcpy(t15, t1, 31U);
    xsi_driver_first_trans_delta(t3, 0U, 31U, 0LL);
    xsi_set_current_line(413, ng0);
    t1 = (t0 + 4872U);
    t2 = *((char **)t1);
    t8 = (32 - 1);
    t9 = (t8 - 31);
    t12 = (t9 * -1);
    t13 = (1U * t12);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t7 = *((unsigned char *)t1);
    t3 = (t0 + 16240);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    *((unsigned char *)t15) = t7;
    xsi_driver_first_trans_fast(t3);
    xsi_set_current_line(414, ng0);
    t1 = (t0 + 16432);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)3;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(415, ng0);
    t1 = (t0 + 16496);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(416, ng0);
    t1 = (t0 + 16368);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((unsigned char *)t5) = (unsigned char)2;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(417, ng0);
    t1 = (t0 + 16560);
    t2 = (t1 + 56U);
    t3 = *((char **)t2);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    *((int *)t5) = 32;
    xsi_driver_first_trans_fast(t1);
    goto LAB2;

LAB12:    if (t8 <= t10)
        goto LAB4;
    else
        goto LAB11;

LAB14:    if (t8 <= t11)
        goto LAB5;
    else
        goto LAB13;

LAB18:;
LAB19:    xsi_set_current_line(401, ng0);
    t1 = (t0 + 16432);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)3;
    xsi_driver_first_trans_fast(t1);
    xsi_set_current_line(402, ng0);
    t1 = (t0 + 4872U);
    t2 = *((char **)t1);
    t8 = (32 - 2);
    t12 = (31 - t8);
    t13 = (t12 * 1U);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t3 = (t0 + 16176);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    memcpy(t15, t1, 31U);
    xsi_driver_first_trans_delta(t3, 0U, 31U, 0LL);
    xsi_set_current_line(403, ng0);
    t1 = (t0 + 4872U);
    t2 = *((char **)t1);
    t8 = (32 - 1);
    t9 = (t8 - 31);
    t12 = (t9 * -1);
    t13 = (1U * t12);
    t14 = (0 + t13);
    t1 = (t2 + t14);
    t7 = *((unsigned char *)t1);
    t3 = (t0 + 16240);
    t4 = (t3 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t15 = *((char **)t6);
    *((unsigned char *)t15) = t7;
    xsi_driver_first_trans_fast(t3);
    goto LAB20;

}

static void work_a_2459373459_1516540902_p_7(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;

LAB0:    xsi_set_current_line(429, ng0);

LAB3:    t1 = (t0 + 5672U);
    t2 = *((char **)t1);
    t1 = (t0 + 16624);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    memcpy(t6, t2, 32U);
    xsi_driver_first_trans_fast_port(t1);

LAB2:    t7 = (t0 + 14480);
    *((int *)t7) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2459373459_1516540902_p_8(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;

LAB0:    xsi_set_current_line(430, ng0);

LAB3:    t1 = (t0 + 7272U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 16688);
    t4 = (t1 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = t3;
    xsi_driver_first_trans_fast_port(t1);

LAB2:    t8 = (t0 + 14496);
    *((int *)t8) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2459373459_1516540902_p_9(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;

LAB0:    xsi_set_current_line(431, ng0);

LAB3:    t1 = (t0 + 8232U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 16752);
    t4 = (t1 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = t3;
    xsi_driver_first_trans_fast_port(t1);

LAB2:    t8 = (t0 + 14512);
    *((int *)t8) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2459373459_1516540902_p_10(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;

LAB0:    xsi_set_current_line(432, ng0);

LAB3:    t1 = (t0 + 5352U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 16816);
    t4 = (t1 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = t3;
    xsi_driver_first_trans_fast_port(t1);

LAB2:    t8 = (t0 + 14528);
    *((int *)t8) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2459373459_1516540902_p_11(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    unsigned char t4;
    char *t5;
    int t6;
    int t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned char t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;
    char *t16;

LAB0:    xsi_set_current_line(441, ng0);
    t1 = (t0 + 4712U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t4 = (t3 == (unsigned char)3);
    if (t4 != 0)
        goto LAB2;

LAB4:    xsi_set_current_line(444, ng0);
    t1 = (t0 + 4552U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 16880);
    t5 = (t1 + 56U);
    t12 = *((char **)t5);
    t13 = (t12 + 56U);
    t14 = *((char **)t13);
    *((unsigned char *)t14) = t3;
    xsi_driver_first_trans_fast_port(t1);

LAB3:    t1 = (t0 + 14544);
    *((int *)t1) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(442, ng0);
    t1 = (t0 + 4872U);
    t5 = *((char **)t1);
    t6 = (32 - 1);
    t7 = (t6 - 31);
    t8 = (t7 * -1);
    t9 = (1U * t8);
    t10 = (0 + t9);
    t1 = (t5 + t10);
    t11 = *((unsigned char *)t1);
    t12 = (t0 + 16880);
    t13 = (t12 + 56U);
    t14 = *((char **)t13);
    t15 = (t14 + 56U);
    t16 = *((char **)t15);
    *((unsigned char *)t16) = t11;
    xsi_driver_first_trans_fast_port(t12);
    goto LAB3;

}

static void work_a_2459373459_1516540902_p_12(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;

LAB0:    xsi_set_current_line(452, ng0);

LAB3:    t1 = (t0 + 5992U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 16944);
    t4 = (t1 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = t3;
    xsi_driver_first_trans_fast_port(t1);

LAB2:    t8 = (t0 + 14560);
    *((int *)t8) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2459373459_1516540902_p_13(char *t0)
{
    char t1[16];
    char *t2;
    char *t3;
    int t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;

LAB0:    xsi_set_current_line(453, ng0);

LAB3:    t2 = (t0 + 3752U);
    t3 = *((char **)t2);
    t4 = *((int *)t3);
    t2 = ieee_p_1242562249_sub_180853171_1035706684(IEEE_P_1242562249, t1, t4, 4);
    t5 = (t0 + 17008);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    t8 = (t7 + 56U);
    t9 = *((char **)t8);
    memcpy(t9, t2, 4U);
    xsi_driver_first_trans_fast_port(t5);

LAB2:    t10 = (t0 + 14576);
    *((int *)t10) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2459373459_1516540902_p_14(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;

LAB0:    xsi_set_current_line(454, ng0);

LAB3:    t1 = (t0 + 4232U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 17072);
    t4 = (t1 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = t3;
    xsi_driver_first_trans_fast_port(t1);

LAB2:    t8 = (t0 + 14592);
    *((int *)t8) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2459373459_1516540902_p_15(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;

LAB0:    xsi_set_current_line(455, ng0);

LAB3:    t1 = (t0 + 5032U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t1 = (t0 + 17136);
    t4 = (t1 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    *((unsigned char *)t7) = t3;
    xsi_driver_first_trans_fast_port(t1);

LAB2:    t8 = (t0 + 14608);
    *((int *)t8) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}

static void work_a_2459373459_1516540902_p_16(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;

LAB0:    xsi_set_current_line(456, ng0);

LAB3:    t1 = (t0 + 4072U);
    t2 = *((char **)t1);
    t1 = (t0 + 17200);
    t3 = (t1 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    memcpy(t6, t2, 32U);
    xsi_driver_first_trans_fast_port(t1);

LAB2:    t7 = (t0 + 14624);
    *((int *)t7) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}


extern void work_a_2459373459_1516540902_init()
{
	static char *pe[] = {(void *)work_a_2459373459_1516540902_p_0,(void *)work_a_2459373459_1516540902_p_1,(void *)work_a_2459373459_1516540902_p_2,(void *)work_a_2459373459_1516540902_p_3,(void *)work_a_2459373459_1516540902_p_4,(void *)work_a_2459373459_1516540902_p_5,(void *)work_a_2459373459_1516540902_p_6,(void *)work_a_2459373459_1516540902_p_7,(void *)work_a_2459373459_1516540902_p_8,(void *)work_a_2459373459_1516540902_p_9,(void *)work_a_2459373459_1516540902_p_10,(void *)work_a_2459373459_1516540902_p_11,(void *)work_a_2459373459_1516540902_p_12,(void *)work_a_2459373459_1516540902_p_13,(void *)work_a_2459373459_1516540902_p_14,(void *)work_a_2459373459_1516540902_p_15,(void *)work_a_2459373459_1516540902_p_16};
	xsi_register_didat("work_a_2459373459_1516540902", "isim/spi2wishbone_tb_isim_beh.exe.sim/work/a_2459373459_1516540902.didat");
	xsi_register_executes(pe);
}
