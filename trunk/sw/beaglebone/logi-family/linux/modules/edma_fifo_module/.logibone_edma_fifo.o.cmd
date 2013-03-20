cmd_/home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/logibone_edma_fifo.o := arm-none-linux-gnueabi-gcc -Wp,-MD,/home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/.logibone_edma_fifo.o.d  -nostdinc -isystem /home/jpiat/development/KERNEL/ARM/beaglebone/toolchain/arm-2009q1/bin/../lib/gcc/arm-none-linux-gnueabi/4.3.3/include -I/home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include -Iarch/arm/include/generated -Iinclude  -include /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/include/linux/kconfig.h -D__KERNEL__ -mlittle-endian -Iarch/arm/mach-omap2/include -Iarch/arm/plat-omap/include -Wall -Wundef -Wstrict-prototypes -Wno-trigraphs -fno-strict-aliasing -fno-common -Werror-implicit-function-declaration -Wno-format-security -fno-delete-null-pointer-checks -Os -marm -mabi=aapcs-linux -mno-thumb-interwork -funwind-tables -mthumb -Wa,-mauto-it -Wa,-mno-warn-deprecated -D__LINUX_ARM_ARCH__=7 -march=armv7-a -msoft-float -Uarm -fno-stack-protector -fomit-frame-pointer -Wdeclaration-after-statement -Wno-pointer-sign -fno-strict-overflow  -DMODULE  -fno-optimize-sibling-calls -D"KBUILD_STR(s)=\#s" -D"KBUILD_BASENAME=KBUILD_STR(logibone_edma_fifo)"  -D"KBUILD_MODNAME=KBUILD_STR(logibone_edma_fifo)" -c -o /home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/.tmp_logibone_edma_fifo.o /home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/logibone_edma_fifo.c

source_/home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/logibone_edma_fifo.o := /home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/logibone_edma_fifo.c

deps_/home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/logibone_edma_fifo.o := \
    $(wildcard include/config/softreset.h) \
    $(wildcard include/config/idlemode.h) \
    $(wildcard include/config/idlemode/noidle.h) \
    $(wildcard include/config/idlemode/shift.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/include/linux/kconfig.h \
    $(wildcard include/config/h.h) \
    $(wildcard include/config/.h) \
    $(wildcard include/config/foo.h) \
  include/linux/init.h \
    $(wildcard include/config/modules.h) \
    $(wildcard include/config/hotplug.h) \
  include/linux/compiler.h \
    $(wildcard include/config/sparse/rcu/pointer.h) \
    $(wildcard include/config/trace/branch/profiling.h) \
    $(wildcard include/config/profile/all/branches.h) \
    $(wildcard include/config/enable/must/check.h) \
    $(wildcard include/config/enable/warn/deprecated.h) \
  include/linux/compiler-gcc.h \
    $(wildcard include/config/arch/supports/optimized/inlining.h) \
    $(wildcard include/config/optimize/inlining.h) \
  include/linux/compiler-gcc4.h \
  include/linux/module.h \
    $(wildcard include/config/symbol/prefix.h) \
    $(wildcard include/config/sysfs.h) \
    $(wildcard include/config/modversions.h) \
    $(wildcard include/config/unused/symbols.h) \
    $(wildcard include/config/generic/bug.h) \
    $(wildcard include/config/kallsyms.h) \
    $(wildcard include/config/smp.h) \
    $(wildcard include/config/tracepoints.h) \
    $(wildcard include/config/tracing.h) \
    $(wildcard include/config/event/tracing.h) \
    $(wildcard include/config/ftrace/mcount/record.h) \
    $(wildcard include/config/module/unload.h) \
    $(wildcard include/config/constructors.h) \
    $(wildcard include/config/debug/set/module/ronx.h) \
  include/linux/list.h \
    $(wildcard include/config/debug/list.h) \
  include/linux/types.h \
    $(wildcard include/config/uid16.h) \
    $(wildcard include/config/lbdaf.h) \
    $(wildcard include/config/arch/dma/addr/t/64bit.h) \
    $(wildcard include/config/phys/addr/t/64bit.h) \
    $(wildcard include/config/64bit.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/types.h \
  include/asm-generic/int-ll64.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/bitsperlong.h \
  include/asm-generic/bitsperlong.h \
  include/linux/posix_types.h \
  include/linux/stddef.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/posix_types.h \
  include/linux/poison.h \
    $(wildcard include/config/illegal/pointer/value.h) \
  include/linux/const.h \
  include/linux/stat.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/stat.h \
  include/linux/time.h \
    $(wildcard include/config/arch/uses/gettimeoffset.h) \
  include/linux/cache.h \
    $(wildcard include/config/arch/has/cache/line/size.h) \
  include/linux/kernel.h \
    $(wildcard include/config/preempt/voluntary.h) \
    $(wildcard include/config/debug/atomic/sleep.h) \
    $(wildcard include/config/prove/locking.h) \
    $(wildcard include/config/ring/buffer.h) \
    $(wildcard include/config/numa.h) \
    $(wildcard include/config/compaction.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/toolchain/arm-2009q1/bin/../lib/gcc/arm-none-linux-gnueabi/4.3.3/include/stdarg.h \
  include/linux/linkage.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/linkage.h \
  include/linux/bitops.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/bitops.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/system.h \
    $(wildcard include/config/function/graph/tracer.h) \
    $(wildcard include/config/cpu/32v6k.h) \
    $(wildcard include/config/cpu/xsc3.h) \
    $(wildcard include/config/cpu/fa526.h) \
    $(wildcard include/config/arch/has/barriers.h) \
    $(wildcard include/config/arm/dma/mem/bufferable.h) \
    $(wildcard include/config/cpu/sa1100.h) \
    $(wildcard include/config/cpu/sa110.h) \
    $(wildcard include/config/cpu/v6.h) \
  include/linux/irqflags.h \
    $(wildcard include/config/trace/irqflags.h) \
    $(wildcard include/config/irqsoff/tracer.h) \
    $(wildcard include/config/preempt/tracer.h) \
    $(wildcard include/config/trace/irqflags/support.h) \
  include/linux/typecheck.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/irqflags.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/ptrace.h \
    $(wildcard include/config/cpu/endian/be8.h) \
    $(wildcard include/config/arm/thumb.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/hwcap.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/outercache.h \
    $(wildcard include/config/outer/cache/sync.h) \
    $(wildcard include/config/outer/cache.h) \
  include/asm-generic/cmpxchg-local.h \
  include/asm-generic/bitops/non-atomic.h \
  include/asm-generic/bitops/fls64.h \
  include/asm-generic/bitops/sched.h \
  include/asm-generic/bitops/hweight.h \
  include/asm-generic/bitops/arch_hweight.h \
  include/asm-generic/bitops/const_hweight.h \
  include/asm-generic/bitops/lock.h \
  include/asm-generic/bitops/le.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/byteorder.h \
  include/linux/byteorder/little_endian.h \
  include/linux/swab.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/swab.h \
  include/linux/byteorder/generic.h \
  include/asm-generic/bitops/ext2-atomic-setbit.h \
  include/linux/log2.h \
    $(wildcard include/config/arch/has/ilog2/u32.h) \
    $(wildcard include/config/arch/has/ilog2/u64.h) \
  include/linux/printk.h \
    $(wildcard include/config/printk.h) \
    $(wildcard include/config/dynamic/debug.h) \
  include/linux/dynamic_debug.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/bug.h \
    $(wildcard include/config/bug.h) \
    $(wildcard include/config/debug/bugverbose.h) \
  include/asm-generic/bug.h \
    $(wildcard include/config/generic/bug/relative/pointers.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/div64.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/cache.h \
    $(wildcard include/config/arm/l1/cache/shift.h) \
    $(wildcard include/config/aeabi.h) \
  include/linux/seqlock.h \
  include/linux/spinlock.h \
    $(wildcard include/config/debug/spinlock.h) \
    $(wildcard include/config/generic/lockbreak.h) \
    $(wildcard include/config/preempt.h) \
    $(wildcard include/config/debug/lock/alloc.h) \
  include/linux/preempt.h \
    $(wildcard include/config/debug/preempt.h) \
    $(wildcard include/config/preempt/count.h) \
    $(wildcard include/config/preempt/notifiers.h) \
  include/linux/thread_info.h \
    $(wildcard include/config/compat.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/thread_info.h \
    $(wildcard include/config/arm/thumbee.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/fpstate.h \
    $(wildcard include/config/vfpv3.h) \
    $(wildcard include/config/iwmmxt.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/domain.h \
    $(wildcard include/config/io/36.h) \
    $(wildcard include/config/cpu/use/domains.h) \
  include/linux/stringify.h \
  include/linux/bottom_half.h \
  include/linux/spinlock_types.h \
  include/linux/spinlock_types_up.h \
  include/linux/lockdep.h \
    $(wildcard include/config/lockdep.h) \
    $(wildcard include/config/lock/stat.h) \
    $(wildcard include/config/prove/rcu.h) \
  include/linux/rwlock_types.h \
  include/linux/spinlock_up.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/processor.h \
    $(wildcard include/config/have/hw/breakpoint.h) \
    $(wildcard include/config/mmu.h) \
    $(wildcard include/config/arm/errata/754327.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/hw_breakpoint.h \
  include/linux/rwlock.h \
  include/linux/spinlock_api_up.h \
  include/linux/atomic.h \
    $(wildcard include/config/arch/has/atomic/or.h) \
    $(wildcard include/config/generic/atomic64.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/atomic.h \
  include/asm-generic/atomic-long.h \
  include/linux/math64.h \
  include/linux/kmod.h \
  include/linux/gfp.h \
    $(wildcard include/config/kmemcheck.h) \
    $(wildcard include/config/highmem.h) \
    $(wildcard include/config/zone/dma.h) \
    $(wildcard include/config/zone/dma32.h) \
  include/linux/mmzone.h \
    $(wildcard include/config/force/max/zoneorder.h) \
    $(wildcard include/config/memory/hotplug.h) \
    $(wildcard include/config/sparsemem.h) \
    $(wildcard include/config/arch/populates/node/map.h) \
    $(wildcard include/config/discontigmem.h) \
    $(wildcard include/config/flat/node/mem/map.h) \
    $(wildcard include/config/cgroup/mem/res/ctlr.h) \
    $(wildcard include/config/no/bootmem.h) \
    $(wildcard include/config/have/memory/present.h) \
    $(wildcard include/config/have/memoryless/nodes.h) \
    $(wildcard include/config/need/node/memmap/size.h) \
    $(wildcard include/config/need/multiple/nodes.h) \
    $(wildcard include/config/have/arch/early/pfn/to/nid.h) \
    $(wildcard include/config/flatmem.h) \
    $(wildcard include/config/sparsemem/extreme.h) \
    $(wildcard include/config/have/arch/pfn/valid.h) \
    $(wildcard include/config/nodes/span/other/nodes.h) \
    $(wildcard include/config/holes/in/zone.h) \
    $(wildcard include/config/arch/has/holes/memorymodel.h) \
  include/linux/wait.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/current.h \
  include/linux/threads.h \
    $(wildcard include/config/nr/cpus.h) \
    $(wildcard include/config/base/small.h) \
  include/linux/numa.h \
    $(wildcard include/config/nodes/shift.h) \
  include/linux/nodemask.h \
  include/linux/bitmap.h \
  include/linux/string.h \
    $(wildcard include/config/binary/printf.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/string.h \
  include/linux/pageblock-flags.h \
    $(wildcard include/config/hugetlb/page.h) \
    $(wildcard include/config/hugetlb/page/size/variable.h) \
  include/generated/bounds.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/page.h \
    $(wildcard include/config/cpu/copy/v3.h) \
    $(wildcard include/config/cpu/copy/v4wt.h) \
    $(wildcard include/config/cpu/copy/v4wb.h) \
    $(wildcard include/config/cpu/copy/feroceon.h) \
    $(wildcard include/config/cpu/copy/fa.h) \
    $(wildcard include/config/cpu/xscale.h) \
    $(wildcard include/config/cpu/copy/v6.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/glue.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/memory.h \
    $(wildcard include/config/page/offset.h) \
    $(wildcard include/config/thumb2/kernel.h) \
    $(wildcard include/config/dram/size.h) \
    $(wildcard include/config/dram/base.h) \
    $(wildcard include/config/have/tcm.h) \
    $(wildcard include/config/arm/patch/phys/virt.h) \
    $(wildcard include/config/arm/patch/phys/virt/16bit.h) \
  arch/arm/mach-omap2/include/mach/memory.h \
  arch/arm/plat-omap/include/plat/memory.h \
    $(wildcard include/config/arch/omap1.h) \
    $(wildcard include/config/arch/omap15xx.h) \
    $(wildcard include/config/fb/omap/consistent/dma/size.h) \
    $(wildcard include/config/fb/da8xx/consistent/dma/size.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/sizes.h \
  include/asm-generic/sizes.h \
  include/asm-generic/memory_model.h \
    $(wildcard include/config/sparsemem/vmemmap.h) \
  include/asm-generic/getorder.h \
  include/linux/memory_hotplug.h \
    $(wildcard include/config/memory/hotremove.h) \
    $(wildcard include/config/have/arch/nodedata/extension.h) \
  include/linux/notifier.h \
  include/linux/errno.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/errno.h \
  include/asm-generic/errno.h \
  include/asm-generic/errno-base.h \
  include/linux/mutex.h \
    $(wildcard include/config/debug/mutexes.h) \
    $(wildcard include/config/have/arch/mutex/cpu/relax.h) \
  include/linux/rwsem.h \
    $(wildcard include/config/rwsem/generic/spinlock.h) \
  include/linux/rwsem-spinlock.h \
  include/linux/srcu.h \
  include/linux/topology.h \
    $(wildcard include/config/sched/smt.h) \
    $(wildcard include/config/sched/mc.h) \
    $(wildcard include/config/sched/book.h) \
    $(wildcard include/config/use/percpu/numa/node/id.h) \
  include/linux/cpumask.h \
    $(wildcard include/config/cpumask/offstack.h) \
    $(wildcard include/config/hotplug/cpu.h) \
    $(wildcard include/config/debug/per/cpu/maps.h) \
    $(wildcard include/config/disable/obsolete/cpumask/functions.h) \
  include/linux/smp.h \
    $(wildcard include/config/use/generic/smp/helpers.h) \
  include/linux/percpu.h \
    $(wildcard include/config/need/per/cpu/embed/first/chunk.h) \
    $(wildcard include/config/need/per/cpu/page/first/chunk.h) \
    $(wildcard include/config/have/setup/per/cpu/area.h) \
  include/linux/pfn.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/percpu.h \
  include/asm-generic/percpu.h \
  include/linux/percpu-defs.h \
    $(wildcard include/config/debug/force/weak/per/cpu.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/topology.h \
  include/asm-generic/topology.h \
  include/linux/mmdebug.h \
    $(wildcard include/config/debug/vm.h) \
    $(wildcard include/config/debug/virtual.h) \
  include/linux/workqueue.h \
    $(wildcard include/config/debug/objects/work.h) \
    $(wildcard include/config/freezer.h) \
  include/linux/timer.h \
    $(wildcard include/config/timer/stats.h) \
    $(wildcard include/config/debug/objects/timers.h) \
  include/linux/ktime.h \
    $(wildcard include/config/ktime/scalar.h) \
  include/linux/jiffies.h \
  include/linux/timex.h \
  include/linux/param.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/param.h \
    $(wildcard include/config/hz.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/timex.h \
  arch/arm/mach-omap2/include/mach/timex.h \
  arch/arm/plat-omap/include/plat/timex.h \
    $(wildcard include/config/omap/32k/timer.h) \
    $(wildcard include/config/omap/32k/timer/hz.h) \
  include/linux/debugobjects.h \
    $(wildcard include/config/debug/objects.h) \
    $(wildcard include/config/debug/objects/free.h) \
  include/linux/sysctl.h \
  include/linux/rcupdate.h \
    $(wildcard include/config/rcu/torture/test.h) \
    $(wildcard include/config/tree/rcu.h) \
    $(wildcard include/config/tree/preempt/rcu.h) \
    $(wildcard include/config/preempt/rcu.h) \
    $(wildcard include/config/no/hz.h) \
    $(wildcard include/config/tiny/rcu.h) \
    $(wildcard include/config/tiny/preempt/rcu.h) \
    $(wildcard include/config/debug/objects/rcu/head.h) \
    $(wildcard include/config/preempt/rt.h) \
  include/linux/completion.h \
  include/linux/rcutiny.h \
  include/linux/elf.h \
  include/linux/elf-em.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/elf.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/user.h \
  include/linux/kobject.h \
  include/linux/sysfs.h \
  include/linux/kobject_ns.h \
  include/linux/kref.h \
  include/linux/moduleparam.h \
    $(wildcard include/config/alpha.h) \
    $(wildcard include/config/ia64.h) \
    $(wildcard include/config/ppc64.h) \
  include/linux/tracepoint.h \
  include/linux/jump_label.h \
    $(wildcard include/config/jump/label.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/module.h \
    $(wildcard include/config/arm/unwind.h) \
  include/trace/events/module.h \
  include/trace/define_trace.h \
  include/linux/pci.h \
    $(wildcard include/config/pci/iov.h) \
    $(wildcard include/config/pcieaspm.h) \
    $(wildcard include/config/pci/msi.h) \
    $(wildcard include/config/pci.h) \
    $(wildcard include/config/pcieportbus.h) \
    $(wildcard include/config/pcieaer.h) \
    $(wildcard include/config/pcie/ecrc.h) \
    $(wildcard include/config/ht/irq.h) \
    $(wildcard include/config/pci/domains.h) \
    $(wildcard include/config/pci/quirks.h) \
    $(wildcard include/config/pci/mmconfig.h) \
    $(wildcard include/config/hotplug/pci.h) \
    $(wildcard include/config/of.h) \
  include/linux/pci_regs.h \
  include/linux/mod_devicetable.h \
  include/linux/ioport.h \
  include/linux/device.h \
    $(wildcard include/config/debug/devres.h) \
    $(wildcard include/config/devtmpfs.h) \
    $(wildcard include/config/sysfs/deprecated.h) \
  include/linux/klist.h \
  include/linux/pm.h \
    $(wildcard include/config/pm.h) \
    $(wildcard include/config/pm/sleep.h) \
    $(wildcard include/config/pm/runtime.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/device.h \
    $(wildcard include/config/dmabounce.h) \
    $(wildcard include/config/arch/omap.h) \
  include/linux/pm_wakeup.h \
  include/linux/io.h \
    $(wildcard include/config/has/ioport.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/io.h \
  arch/arm/mach-omap2/include/mach/io.h \
  arch/arm/plat-omap/include/plat/io.h \
    $(wildcard include/config/arch/omap730.h) \
    $(wildcard include/config/arch/omap850.h) \
    $(wildcard include/config/arch/omap16xx.h) \
    $(wildcard include/config/soc/omap2420.h) \
    $(wildcard include/config/soc/omap2430.h) \
    $(wildcard include/config/arch/omap3.h) \
    $(wildcard include/config/soc/omapti816x.h) \
    $(wildcard include/config/soc/omapam33xx.h) \
    $(wildcard include/config/arch/omap4.h) \
  arch/arm/mach-omap2/include/mach/hardware.h \
  arch/arm/plat-omap/include/plat/hardware.h \
    $(wildcard include/config/reg/base.h) \
  arch/arm/plat-omap/include/plat/cpu.h \
    $(wildcard include/config/arch/omap2.h) \
    $(wildcard include/config/soc/omap3430.h) \
  arch/arm/plat-omap/include/plat/multi.h \
    $(wildcard include/config/arch/omap2plus.h) \
  arch/arm/plat-omap/include/plat/serial.h \
  arch/arm/plat-omap/include/plat/omap7xx.h \
    $(wildcard include/config/base.h) \
  arch/arm/plat-omap/include/plat/omap1510.h \
  arch/arm/plat-omap/include/plat/omap16xx.h \
  arch/arm/plat-omap/include/plat/omap24xx.h \
  arch/arm/plat-omap/include/plat/omap34xx.h \
  arch/arm/plat-omap/include/plat/omap44xx.h \
  arch/arm/plat-omap/include/plat/ti816x.h \
  arch/arm/plat-omap/include/plat/am33xx.h \
  include/linux/irqreturn.h \
  include/linux/pci_ids.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/pci.h \
    $(wildcard include/config/pci/host/ite8152.h) \
  include/asm-generic/pci-dma-compat.h \
  include/linux/dma-mapping.h \
    $(wildcard include/config/has/dma.h) \
    $(wildcard include/config/have/dma/attrs.h) \
    $(wildcard include/config/need/dma/map/state.h) \
  include/linux/err.h \
  include/linux/dma-attrs.h \
  include/linux/bug.h \
  include/linux/dma-direction.h \
  include/linux/scatterlist.h \
    $(wildcard include/config/debug/sg.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/scatterlist.h \
    $(wildcard include/config/arm/has/sg/chain.h) \
  include/asm-generic/scatterlist.h \
    $(wildcard include/config/need/sg/dma/length.h) \
  include/linux/mm.h \
    $(wildcard include/config/sysctl.h) \
    $(wildcard include/config/stack/growsup.h) \
    $(wildcard include/config/transparent/hugepage.h) \
    $(wildcard include/config/ksm.h) \
    $(wildcard include/config/proc/fs.h) \
    $(wildcard include/config/debug/pagealloc.h) \
    $(wildcard include/config/hibernation.h) \
    $(wildcard include/config/hugetlbfs.h) \
  include/linux/rbtree.h \
  include/linux/prio_tree.h \
  include/linux/debug_locks.h \
    $(wildcard include/config/debug/locking/api/selftests.h) \
  include/linux/mm_types.h \
    $(wildcard include/config/split/ptlock/cpus.h) \
    $(wildcard include/config/want/page/debug/flags.h) \
    $(wildcard include/config/slub.h) \
    $(wildcard include/config/cmpxchg/local.h) \
    $(wildcard include/config/aio.h) \
    $(wildcard include/config/mm/owner.h) \
    $(wildcard include/config/mmu/notifier.h) \
  include/linux/auxvec.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/auxvec.h \
  include/linux/page-debug-flags.h \
    $(wildcard include/config/page/poisoning.h) \
    $(wildcard include/config/page/debug/something/else.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/mmu.h \
    $(wildcard include/config/cpu/has/asid.h) \
  include/linux/range.h \
  include/linux/bit_spinlock.h \
  include/linux/shrinker.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/pgtable.h \
    $(wildcard include/config/highpte.h) \
  include/asm-generic/4level-fixup.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/proc-fns.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/glue-proc.h \
    $(wildcard include/config/cpu/arm610.h) \
    $(wildcard include/config/cpu/arm7tdmi.h) \
    $(wildcard include/config/cpu/arm710.h) \
    $(wildcard include/config/cpu/arm720t.h) \
    $(wildcard include/config/cpu/arm740t.h) \
    $(wildcard include/config/cpu/arm9tdmi.h) \
    $(wildcard include/config/cpu/arm920t.h) \
    $(wildcard include/config/cpu/arm922t.h) \
    $(wildcard include/config/cpu/arm925t.h) \
    $(wildcard include/config/cpu/arm926t.h) \
    $(wildcard include/config/cpu/arm940t.h) \
    $(wildcard include/config/cpu/arm946e.h) \
    $(wildcard include/config/cpu/arm1020.h) \
    $(wildcard include/config/cpu/arm1020e.h) \
    $(wildcard include/config/cpu/arm1022.h) \
    $(wildcard include/config/cpu/arm1026.h) \
    $(wildcard include/config/cpu/mohawk.h) \
    $(wildcard include/config/cpu/feroceon.h) \
    $(wildcard include/config/cpu/v6k.h) \
    $(wildcard include/config/cpu/v7.h) \
  arch/arm/mach-omap2/include/mach/vmalloc.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/pgtable-hwdef.h \
  include/asm-generic/pgtable.h \
  include/linux/page-flags.h \
    $(wildcard include/config/pageflags/extended.h) \
    $(wildcard include/config/arch/uses/pg/uncached.h) \
    $(wildcard include/config/memory/failure.h) \
    $(wildcard include/config/swap.h) \
    $(wildcard include/config/s390.h) \
  include/linux/huge_mm.h \
  include/linux/vmstat.h \
    $(wildcard include/config/vm/event/counters.h) \
  include/linux/vm_event_item.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/dma-mapping.h \
  include/linux/dma-debug.h \
    $(wildcard include/config/dma/api/debug.h) \
  include/asm-generic/dma-coherent.h \
    $(wildcard include/config/have/generic/dma/coherent.h) \
  include/asm-generic/pci-bridge.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/mach/pci.h \
  include/linux/interrupt.h \
    $(wildcard include/config/generic/hardirqs.h) \
    $(wildcard include/config/irq/forced/threading.h) \
    $(wildcard include/config/generic/irq/probe.h) \
  include/linux/irqnr.h \
  include/linux/hardirq.h \
    $(wildcard include/config/virt/cpu/accounting.h) \
    $(wildcard include/config/irq/time/accounting.h) \
  include/linux/ftrace_irq.h \
    $(wildcard include/config/ftrace/nmi/enter.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/hardirq.h \
    $(wildcard include/config/local/timers.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/irq.h \
  arch/arm/mach-omap2/include/mach/irqs.h \
  arch/arm/plat-omap/include/plat/irqs.h \
    $(wildcard include/config/mach/omap/innovator.h) \
    $(wildcard include/config/twl4030/core.h) \
    $(wildcard include/config/gpio/twl4030.h) \
    $(wildcard include/config/twl6040/codec.h) \
    $(wildcard include/config/fiq.h) \
  arch/arm/plat-omap/include/plat/irqs-44xx.h \
  arch/arm/plat-omap/include/plat/irqs-am33xx.h \
  include/linux/irq_cpustat.h \
  include/linux/hrtimer.h \
    $(wildcard include/config/high/res/timers.h) \
    $(wildcard include/config/timerfd.h) \
  include/linux/timerqueue.h \
  include/trace/events/irq.h \
  include/linux/fs.h \
    $(wildcard include/config/fs/posix/acl.h) \
    $(wildcard include/config/security.h) \
    $(wildcard include/config/quota.h) \
    $(wildcard include/config/fsnotify.h) \
    $(wildcard include/config/ima.h) \
    $(wildcard include/config/epoll.h) \
    $(wildcard include/config/debug/writecount.h) \
    $(wildcard include/config/file/locking.h) \
    $(wildcard include/config/auditsyscall.h) \
    $(wildcard include/config/block.h) \
    $(wildcard include/config/fs/xip.h) \
    $(wildcard include/config/migration.h) \
  include/linux/limits.h \
  include/linux/ioctl.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/ioctl.h \
  include/asm-generic/ioctl.h \
  include/linux/blk_types.h \
    $(wildcard include/config/blk/dev/integrity.h) \
  include/linux/kdev_t.h \
  include/linux/dcache.h \
  include/linux/rculist.h \
  include/linux/rculist_bl.h \
  include/linux/list_bl.h \
  include/linux/path.h \
  include/linux/radix-tree.h \
  include/linux/pid.h \
  include/linux/capability.h \
  include/linux/semaphore.h \
  include/linux/fiemap.h \
  include/linux/quota.h \
    $(wildcard include/config/quota/netlink/interface.h) \
  include/linux/percpu_counter.h \
  include/linux/dqblk_xfs.h \
  include/linux/dqblk_v1.h \
  include/linux/dqblk_v2.h \
  include/linux/dqblk_qtree.h \
  include/linux/nfs_fs_i.h \
  include/linux/nfs.h \
  include/linux/sunrpc/msg_prot.h \
  include/linux/inet.h \
  include/linux/fcntl.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/fcntl.h \
  include/asm-generic/fcntl.h \
  include/linux/slab.h \
    $(wildcard include/config/slab/debug.h) \
    $(wildcard include/config/failslab.h) \
    $(wildcard include/config/slob.h) \
    $(wildcard include/config/debug/slab.h) \
    $(wildcard include/config/slab.h) \
  include/linux/slab_def.h \
  include/trace/events/kmem.h \
  include/trace/events/gfpflags.h \
  include/linux/kmalloc_sizes.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/uaccess.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/unified.h \
    $(wildcard include/config/arm/asm/unified.h) \
  include/linux/cdev.h \
  include/linux/sched.h \
    $(wildcard include/config/sched/debug.h) \
    $(wildcard include/config/lockup/detector.h) \
    $(wildcard include/config/detect/hung/task.h) \
    $(wildcard include/config/core/dump/default/elf/headers.h) \
    $(wildcard include/config/sched/autogroup.h) \
    $(wildcard include/config/bsd/process/acct.h) \
    $(wildcard include/config/taskstats.h) \
    $(wildcard include/config/audit.h) \
    $(wildcard include/config/cgroups.h) \
    $(wildcard include/config/inotify/user.h) \
    $(wildcard include/config/fanotify.h) \
    $(wildcard include/config/posix/mqueue.h) \
    $(wildcard include/config/keys.h) \
    $(wildcard include/config/perf/events.h) \
    $(wildcard include/config/schedstats.h) \
    $(wildcard include/config/task/delay/acct.h) \
    $(wildcard include/config/fair/group/sched.h) \
    $(wildcard include/config/rt/group/sched.h) \
    $(wildcard include/config/blk/dev/io/trace.h) \
    $(wildcard include/config/rcu/boost.h) \
    $(wildcard include/config/compat/brk.h) \
    $(wildcard include/config/cc/stackprotector.h) \
    $(wildcard include/config/sysvipc.h) \
    $(wildcard include/config/rt/mutexes.h) \
    $(wildcard include/config/task/xacct.h) \
    $(wildcard include/config/cpusets.h) \
    $(wildcard include/config/futex.h) \
    $(wildcard include/config/fault/injection.h) \
    $(wildcard include/config/latencytop.h) \
    $(wildcard include/config/have/unstable/sched/clock.h) \
    $(wildcard include/config/debug/stack/usage.h) \
    $(wildcard include/config/cgroup/sched.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/cputime.h \
  include/asm-generic/cputime.h \
  include/linux/sem.h \
  include/linux/ipc.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/ipcbuf.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/sembuf.h \
  include/linux/signal.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/signal.h \
  include/asm-generic/signal-defs.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/sigcontext.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/siginfo.h \
  include/asm-generic/siginfo.h \
  include/linux/proportions.h \
  include/linux/seccomp.h \
    $(wildcard include/config/seccomp.h) \
  include/linux/rtmutex.h \
    $(wildcard include/config/debug/rt/mutexes.h) \
  include/linux/plist.h \
    $(wildcard include/config/debug/pi/list.h) \
  include/linux/resource.h \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/resource.h \
  include/asm-generic/resource.h \
  include/linux/task_io_accounting.h \
    $(wildcard include/config/task/io/accounting.h) \
  include/linux/latencytop.h \
  include/linux/cred.h \
    $(wildcard include/config/debug/credentials.h) \
    $(wildcard include/config/user/ns.h) \
  include/linux/key.h \
  include/linux/selinux.h \
    $(wildcard include/config/security/selinux.h) \
  include/linux/aio.h \
  include/linux/aio_abi.h \
  include/linux/uio.h \
  arch/arm/mach-omap2/include/mach/edma.h \
  include/linux/gpio.h \
    $(wildcard include/config/generic/gpio.h) \
  /home/jpiat/development/KERNEL/ARM/beaglebone/kernels/ti33x-psp-3.1/arch/arm/include/asm/gpio.h \
  arch/arm/mach-omap2/include/mach/gpio.h \
  arch/arm/plat-omap/include/plat/gpio.h \
  include/linux/platform_device.h \
    $(wildcard include/config/suspend.h) \
    $(wildcard include/config/hibernate/callbacks.h) \
  include/asm-generic/gpio.h \
    $(wildcard include/config/gpiolib.h) \
    $(wildcard include/config/of/gpio.h) \
    $(wildcard include/config/gpio/sysfs.h) \
  /home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/hw_cm_per.h \
  /home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/hw_gpmc.h \
    $(wildcard include/config/autoidle.h) \
    $(wildcard include/config/autoidle/shift.h) \
    $(wildcard include/config/autoidle/autorun.h) \
    $(wildcard include/config/autoidle/freerun.h) \
    $(wildcard include/config/idlemode/forceidle.h) \
    $(wildcard include/config/idlemode/reserved.h) \
    $(wildcard include/config/idlemode/smartidle.h) \
    $(wildcard include/config/softreset/shift.h) \
    $(wildcard include/config/softreset/normal.h) \
    $(wildcard include/config/softreset/reset.h) \
    $(wildcard include/config/limitedaddress.h) \
    $(wildcard include/config/limitedaddress/shift.h) \
    $(wildcard include/config/limitedaddress/limited.h) \
    $(wildcard include/config/limitedaddress/nolimited.h) \
    $(wildcard include/config/nandforcepostedwrite.h) \
    $(wildcard include/config/nandforcepostedwrite/shift.h) \
    $(wildcard include/config/nandforcepostedwrite/forcepwr.h) \
    $(wildcard include/config/nandforcepostedwrite/noforcepwr.h) \
    $(wildcard include/config/wait0pinpolarity.h) \
    $(wildcard include/config/wait0pinpolarity/shift.h) \
    $(wildcard include/config/wait0pinpolarity/w0activeh.h) \
    $(wildcard include/config/wait0pinpolarity/w0activel.h) \
    $(wildcard include/config/wait1pinpolarity.h) \
    $(wildcard include/config/wait1pinpolarity/shift.h) \
    $(wildcard include/config/wait1pinpolarity/w1activeh.h) \
    $(wildcard include/config/wait1pinpolarity/w1activel.h) \
    $(wildcard include/config/wait2pinpolarity.h) \
    $(wildcard include/config/wait2pinpolarity/shift.h) \
    $(wildcard include/config/wait2pinpolarity/w2activeh.h) \
    $(wildcard include/config/wait2pinpolarity/w2activel.h) \
    $(wildcard include/config/wait3pinpolarity.h) \
    $(wildcard include/config/wait3pinpolarity/shift.h) \
    $(wildcard include/config/writeprotect.h) \
    $(wildcard include/config/writeprotect/shift.h) \
    $(wildcard include/config/writeprotect/wphigh.h) \
    $(wildcard include/config/writeprotect/wplow.h) \
    $(wildcard include/config/ecc16b.h) \
    $(wildcard include/config/ecc16b/shift.h) \
    $(wildcard include/config/ecc16b/eightcol.h) \
    $(wildcard include/config/ecc16b/sixteencol.h) \
    $(wildcard include/config/eccalgorithm.h) \
    $(wildcard include/config/eccalgorithm/shift.h) \
    $(wildcard include/config/eccalgorithm/bch/code.h) \
    $(wildcard include/config/eccalgorithm/hamming/code.h) \
    $(wildcard include/config/eccbchtsel.h) \
    $(wildcard include/config/eccbchtsel/shift.h) \
    $(wildcard include/config/eccbchtsel/upto/16bits.h) \
    $(wildcard include/config/eccbchtsel/upto/4bits.h) \
    $(wildcard include/config/eccbchtsel/upto/8bits.h) \
    $(wildcard include/config/ecccs.h) \
    $(wildcard include/config/ecccs/shift.h) \
    $(wildcard include/config/ecccs/cs0.h) \
    $(wildcard include/config/ecccs/cs1.h) \
    $(wildcard include/config/ecccs/cs2.h) \
    $(wildcard include/config/ecccs/cs3.h) \
    $(wildcard include/config/ecccs/cs4.h) \
    $(wildcard include/config/ecccs/cs5.h) \
    $(wildcard include/config/ecccs/cs6.h) \
    $(wildcard include/config/ecccs/cs7.h) \
    $(wildcard include/config/eccenable.h) \
    $(wildcard include/config/eccenable/shift.h) \
    $(wildcard include/config/eccenable/eccdisabled.h) \
    $(wildcard include/config/eccenable/eccenabled.h) \
    $(wildcard include/config/ecctopsector.h) \
    $(wildcard include/config/ecctopsector/shift.h) \
    $(wildcard include/config/eccwrapmode.h) \
    $(wildcard include/config/eccwrapmode/shift.h) \
    $(wildcard include/config/ecc1resultsize.h) \
    $(wildcard include/config/ecc1resultsize/shift.h) \
    $(wildcard include/config/ecc1resultsize/size0sel.h) \
    $(wildcard include/config/ecc1resultsize/size1sel.h) \
    $(wildcard include/config/ecc2resultsize.h) \
    $(wildcard include/config/ecc2resultsize/shift.h) \
    $(wildcard include/config/ecc2resultsize/size0sel.h) \
    $(wildcard include/config/ecc2resultsize/size1sel.h) \
    $(wildcard include/config/ecc3resultsize.h) \
    $(wildcard include/config/ecc3resultsize/shift.h) \
    $(wildcard include/config/ecc3resultsize/size0sel.h) \
    $(wildcard include/config/ecc3resultsize/size1sel.h) \
    $(wildcard include/config/ecc4resultsize.h) \
    $(wildcard include/config/ecc4resultsize/shift.h) \
    $(wildcard include/config/ecc4resultsize/size0sel.h) \
    $(wildcard include/config/ecc4resultsize/size1sel.h) \
    $(wildcard include/config/ecc5resultsize.h) \
    $(wildcard include/config/ecc5resultsize/shift.h) \
    $(wildcard include/config/ecc5resultsize/size0sel.h) \
    $(wildcard include/config/ecc5resultsize/size1sel.h) \
    $(wildcard include/config/ecc6resultsize.h) \
    $(wildcard include/config/ecc6resultsize/shift.h) \
    $(wildcard include/config/ecc6resultsize/size0sel.h) \
    $(wildcard include/config/ecc6resultsize/size1sel.h) \
    $(wildcard include/config/ecc7resultsize.h) \
    $(wildcard include/config/ecc7resultsize/shift.h) \
    $(wildcard include/config/ecc7resultsize/size0sel.h) \
    $(wildcard include/config/ecc7resultsize/size1sel.h) \
    $(wildcard include/config/ecc8resultsize.h) \
    $(wildcard include/config/ecc8resultsize/shift.h) \
    $(wildcard include/config/ecc8resultsize/size0sel.h) \
    $(wildcard include/config/ecc8resultsize/size1sel.h) \
    $(wildcard include/config/ecc9resultsize.h) \
    $(wildcard include/config/ecc9resultsize/shift.h) \
    $(wildcard include/config/ecc9resultsize/size0sel.h) \
    $(wildcard include/config/ecc9resultsize/size1sel.h) \
    $(wildcard include/config/eccsize0.h) \
    $(wildcard include/config/eccsize0/shift.h) \
    $(wildcard include/config/eccsize1.h) \
    $(wildcard include/config/eccsize1/shift.h) \
  /home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/soc_AM335x.h \
    $(wildcard include/config/regs.h) \

/home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/logibone_edma_fifo.o: $(deps_/home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/logibone_edma_fifo.o)

$(deps_/home/jpiat/development/FPGA/fpga-cam/sw/beaglebone/logibone_edma_demo/edma_module/logibone_edma_fifo.o):
