import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaySeven {

    private final Folder root = new Folder();

    public DaySeven(String lines) {
        List<String> input = Arrays.asList(lines.split("\n"));
        root.name = "/";
        Folder currentFolder = root;
        for(int i = 1; i < input.size(); i++) {
            String[] parts = input.get(i).split(" ");
            if(parts[0].equals("$")) {
                if(parts[1].equals("cd")) {
                    if(parts[2].equals(".."))
                        currentFolder = currentFolder.parent;
                    else {
                        for(Node n: currentFolder.contents) {
                            if(n.name.equals(parts[2])) {
                                currentFolder = (Folder) n;
                                break;
                            }
                        }
                    }
                }
            } else if(parts[0].equals("dir")) {
                Folder folder = new Folder();
                folder.parent = currentFolder;
                folder.name = parts[1];
                currentFolder.contents.add(folder);
            } else {
                File file = new File();
                file.parent = currentFolder;
                file.name = parts[1];
                file.size = Integer.parseInt(parts[0]);
                currentFolder.contents.add(file);
            }
        }
    }

    public long partOne() {
        List<Folder> toCheck = new ArrayList<>(root.getSubFolders());
        long sum = 0;
        while(toCheck.size() > 0) {
            Folder fold = toCheck.remove(0);
            toCheck.addAll(fold.getSubFolders());
            if(fold.getSize() <= 100000)
                sum += fold.getSize();
        }
        return sum;
    }

    private long partTwo() {
        List<Folder> toCheck = new ArrayList<>(root.getSubFolders());
        long totalSpace = 70000000;
        long freeSpace = totalSpace - root.getSize();
        long smallestFree = Integer.MAX_VALUE;
        ;
        while(toCheck.size() > 0) {
            Folder fold = toCheck.remove(0);
            toCheck.addAll(fold.getSubFolders());
            long size = fold.getSize();
            if(freeSpace + size > 30000000 && size < smallestFree)
                smallestFree = size;
        }
        return smallestFree;
    }

    public static void main(String[] args) {
        DaySeven daySeven = new DaySeven(lines);
        System.out.printf("Part one: %d\n", daySeven.partOne());
        System.out.printf("Part two: %d\n", daySeven.partTwo());
    }

    public static abstract class Node {
        public String name;
        public Folder parent;

        public abstract long getSize();
    }

    public static class File extends Node {
        public int size;

        public long getSize() {
            return size;
        }
    }

    public static class Folder extends Node {
        public List<Node> contents = new ArrayList<>();

        public List<Folder> getSubFolders() {
            List<Folder> folders = new ArrayList<>();
            for(Node n : contents)
                if(n instanceof Folder)
                    folders.add((Folder)n);
            return folders;
        }

        public long getSize() {
            long size = 0;
            for(Node n: contents)
                size += n.getSize();
            return size;
        }
    }

    private static final String lines = "$ cd /\n" +
                                        "$ ls\n" +
                                        "dir btsgrbd\n" +
                                        "3868 cprq.fmm\n" +
                                        "dir gcbpcf\n" +
                                        "dir hfm\n" +
                                        "324644 lthcng.gnf\n" +
                                        "133181 nblfzrb.mrr\n" +
                                        "140568 sfrbjmmh.jnj\n" +
                                        "dir tfsh\n" +
                                        "dir vlsqgrw\n" +
                                        "202279 vmpgqbcd\n" +
                                        "$ cd btsgrbd\n" +
                                        "$ ls\n" +
                                        "dir cmfdm\n" +
                                        "dir cqd\n" +
                                        "dir gvwvs\n" +
                                        "dir nblfzrb\n" +
                                        "dir nfm\n" +
                                        "293979 qwnml.bqn\n" +
                                        "159220 sdwnsgwv.mjm\n" +
                                        "327978 vzgwwjq.zbp\n" +
                                        "155479 zvspnvfr.zbc\n" +
                                        "$ cd cmfdm\n" +
                                        "$ ls\n" +
                                        "dir gldnjj\n" +
                                        "dir vhf\n" +
                                        "$ cd gldnjj\n" +
                                        "$ ls\n" +
                                        "dir dvght\n" +
                                        "93750 lwvtzd.pws\n" +
                                        "176529 sdwnsgwv.mjm\n" +
                                        "100111 vmpgqbcd\n" +
                                        "$ cd dvght\n" +
                                        "$ ls\n" +
                                        "dir tfbzq\n" +
                                        "$ cd tfbzq\n" +
                                        "$ ls\n" +
                                        "276592 tcghw.srg\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd vhf\n" +
                                        "$ ls\n" +
                                        "240217 hfm.rfp\n" +
                                        "dir nblfzrb\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "160378 jhc\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd cqd\n" +
                                        "$ ls\n" +
                                        "305358 bnddfgrb\n" +
                                        "dir dwqncqp\n" +
                                        "dir hnnfdtbh\n" +
                                        "dir jhc\n" +
                                        "dir nblfzrb\n" +
                                        "327762 scnm.qbf\n" +
                                        "165080 vmpgqbcd\n" +
                                        "190041 vzgwwjq.zbp\n" +
                                        "dir zwv\n" +
                                        "$ cd dwqncqp\n" +
                                        "$ ls\n" +
                                        "122570 slpgmhv\n" +
                                        "278461 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd hnnfdtbh\n" +
                                        "$ ls\n" +
                                        "334830 gfprhn.rjj\n" +
                                        "$ cd ..\n" +
                                        "$ cd jhc\n" +
                                        "$ ls\n" +
                                        "179593 fgb.btb\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "dir clbcgvhc\n" +
                                        "dir jhc\n" +
                                        "dir lsrnz\n" +
                                        "dir mctd\n" +
                                        "$ cd clbcgvhc\n" +
                                        "$ ls\n" +
                                        "285825 hnn\n" +
                                        "238272 nblfzrb.wvr\n" +
                                        "$ cd ..\n" +
                                        "$ cd jhc\n" +
                                        "$ ls\n" +
                                        "99731 nblfzrb.svz\n" +
                                        "$ cd ..\n" +
                                        "$ cd lsrnz\n" +
                                        "$ ls\n" +
                                        "257843 fsthnpmd\n" +
                                        "$ cd ..\n" +
                                        "$ cd mctd\n" +
                                        "$ ls\n" +
                                        "278117 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd zwv\n" +
                                        "$ ls\n" +
                                        "40349 jhc\n" +
                                        "dir pqwml\n" +
                                        "173804 sdwnsgwv.mjm\n" +
                                        "$ cd pqwml\n" +
                                        "$ ls\n" +
                                        "193573 hbzvzwpr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd gvwvs\n" +
                                        "$ ls\n" +
                                        "dir gjslw\n" +
                                        "dir gwz\n" +
                                        "dir ljvrjp\n" +
                                        "dir sltlpb\n" +
                                        "dir vbsnq\n" +
                                        "$ cd gjslw\n" +
                                        "$ ls\n" +
                                        "dir gzbm\n" +
                                        "$ cd gzbm\n" +
                                        "$ ls\n" +
                                        "dir fst\n" +
                                        "dir gpjz\n" +
                                        "dir gzd\n" +
                                        "dir hfm\n" +
                                        "$ cd fst\n" +
                                        "$ ls\n" +
                                        "99806 mqpg\n" +
                                        "$ cd ..\n" +
                                        "$ cd gpjz\n" +
                                        "$ ls\n" +
                                        "dir dnsvsp\n" +
                                        "218828 jhc.dfd\n" +
                                        "$ cd dnsvsp\n" +
                                        "$ ls\n" +
                                        "dir vmdbpwj\n" +
                                        "dir zvspnvfr\n" +
                                        "$ cd vmdbpwj\n" +
                                        "$ ls\n" +
                                        "258373 jhc\n" +
                                        "$ cd ..\n" +
                                        "$ cd zvspnvfr\n" +
                                        "$ ls\n" +
                                        "18241 vzgwwjq.zbp\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd gzd\n" +
                                        "$ ls\n" +
                                        "20383 chdfwj\n" +
                                        "63309 prrlv.rvn\n" +
                                        "$ cd ..\n" +
                                        "$ cd hfm\n" +
                                        "$ ls\n" +
                                        "291753 qhh\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd gwz\n" +
                                        "$ ls\n" +
                                        "29042 hfm.hpn\n" +
                                        "184043 mpc\n" +
                                        "230539 sdwnsgwv.mjm\n" +
                                        "803 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ljvrjp\n" +
                                        "$ ls\n" +
                                        "44312 pfltqw.zvc\n" +
                                        "$ cd ..\n" +
                                        "$ cd sltlpb\n" +
                                        "$ ls\n" +
                                        "321945 sdwnsgwv.mjm\n" +
                                        "$ cd ..\n" +
                                        "$ cd vbsnq\n" +
                                        "$ ls\n" +
                                        "7774 twbbg.ftq\n" +
                                        "109546 zpqbp.cts\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "89034 fst\n" +
                                        "338143 sdwnsgwv.mjm\n" +
                                        "130661 vmpgqbcd\n" +
                                        "130071 vrj.zlb\n" +
                                        "$ cd ..\n" +
                                        "$ cd nfm\n" +
                                        "$ ls\n" +
                                        "327853 fwmfmtt.hdg\n" +
                                        "151272 vdjs\n" +
                                        "dir wznwjfw\n" +
                                        "75692 zlnbcwr\n" +
                                        "$ cd wznwjfw\n" +
                                        "$ ls\n" +
                                        "dir nblfzrb\n" +
                                        "dir zvspnvfr\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "271817 fpqfgs.gdl\n" +
                                        "$ cd ..\n" +
                                        "$ cd zvspnvfr\n" +
                                        "$ ls\n" +
                                        "dir hfm\n" +
                                        "dir mdftsf\n" +
                                        "$ cd hfm\n" +
                                        "$ ls\n" +
                                        "dir fsgdq\n" +
                                        "dir grj\n" +
                                        "$ cd fsgdq\n" +
                                        "$ ls\n" +
                                        "244565 sdwnsgwv.mjm\n" +
                                        "$ cd ..\n" +
                                        "$ cd grj\n" +
                                        "$ ls\n" +
                                        "200989 rdvvrjf.fwz\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd mdftsf\n" +
                                        "$ ls\n" +
                                        "dir fnzztppm\n" +
                                        "21425 jhc.mtl\n" +
                                        "$ cd fnzztppm\n" +
                                        "$ ls\n" +
                                        "159263 bvf\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd gcbpcf\n" +
                                        "$ ls\n" +
                                        "295086 gfprhn.rjj\n" +
                                        "dir ldwwls\n" +
                                        "dir nblfzrb\n" +
                                        "dir zvspnvfr\n" +
                                        "dir zwv\n" +
                                        "$ cd ldwwls\n" +
                                        "$ ls\n" +
                                        "175977 sdwnsgwv.mjm\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "dir mzshzw\n" +
                                        "$ cd mzshzw\n" +
                                        "$ ls\n" +
                                        "dir mllqf\n" +
                                        "$ cd mllqf\n" +
                                        "$ ls\n" +
                                        "113563 hfm.svt\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd zvspnvfr\n" +
                                        "$ ls\n" +
                                        "84524 fst\n" +
                                        "dir jhc\n" +
                                        "dir llnqc\n" +
                                        "126979 nnrwp.shv\n" +
                                        "dir npjd\n" +
                                        "dir nptwgdbn\n" +
                                        "133618 qtn\n" +
                                        "dir rddftb\n" +
                                        "dir thfhbhz\n" +
                                        "129882 vmpgqbcd\n" +
                                        "170834 zlnbcwr\n" +
                                        "$ cd jhc\n" +
                                        "$ ls\n" +
                                        "dir pjlj\n" +
                                        "dir tfljr\n" +
                                        "$ cd pjlj\n" +
                                        "$ ls\n" +
                                        "dir jhc\n" +
                                        "$ cd jhc\n" +
                                        "$ ls\n" +
                                        "dir hqzm\n" +
                                        "$ cd hqzm\n" +
                                        "$ ls\n" +
                                        "159505 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd tfljr\n" +
                                        "$ ls\n" +
                                        "dir dwhjmg\n" +
                                        "$ cd dwhjmg\n" +
                                        "$ ls\n" +
                                        "dir nblfzrb\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "194723 ppptz\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd llnqc\n" +
                                        "$ ls\n" +
                                        "194898 vzgwwjq.zbp\n" +
                                        "$ cd ..\n" +
                                        "$ cd npjd\n" +
                                        "$ ls\n" +
                                        "dir blvfljfn\n" +
                                        "dir dzpplzl\n" +
                                        "101118 gfprhn.rjj\n" +
                                        "116164 hbbnl.nvz\n" +
                                        "211685 hfm\n" +
                                        "dir jhc\n" +
                                        "dir mcnftw\n" +
                                        "dir nblfzrb\n" +
                                        "dir ncpchrj\n" +
                                        "dir qrdczsdf\n" +
                                        "165190 ttbj\n" +
                                        "190954 vzgwwjq.zbp\n" +
                                        "$ cd blvfljfn\n" +
                                        "$ ls\n" +
                                        "283460 gfprhn.rjj\n" +
                                        "148100 sqljld\n" +
                                        "$ cd ..\n" +
                                        "$ cd dzpplzl\n" +
                                        "$ ls\n" +
                                        "62592 jjlvdvq.mqp\n" +
                                        "$ cd ..\n" +
                                        "$ cd jhc\n" +
                                        "$ ls\n" +
                                        "90578 dvd.wvl\n" +
                                        "165955 zqplggf\n" +
                                        "$ cd ..\n" +
                                        "$ cd mcnftw\n" +
                                        "$ ls\n" +
                                        "157908 gbqpdt\n" +
                                        "dir jsnrcfbv\n" +
                                        "dir nblfzrb\n" +
                                        "322169 qlmd.dbq\n" +
                                        "dir zvspnvfr\n" +
                                        "$ cd jsnrcfbv\n" +
                                        "$ ls\n" +
                                        "dir gffj\n" +
                                        "75682 hfm\n" +
                                        "dir pmfwlzn\n" +
                                        "160494 vzgwwjq.zbp\n" +
                                        "$ cd gffj\n" +
                                        "$ ls\n" +
                                        "dir nblfzrb\n" +
                                        "9340 pcqs\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "216547 sdwnsgwv.mjm\n" +
                                        "135235 zvspnvfr.nvs\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd pmfwlzn\n" +
                                        "$ ls\n" +
                                        "137069 jbsmwm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "dir hflnbmcd\n" +
                                        "11899 vzgwwjq.zbp\n" +
                                        "334607 whmq.ftc\n" +
                                        "347595 zlnbcwr\n" +
                                        "$ cd hflnbmcd\n" +
                                        "$ ls\n" +
                                        "275968 sdwnsgwv.mjm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd zvspnvfr\n" +
                                        "$ ls\n" +
                                        "75213 vmpgqbcd\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "dir jhc\n" +
                                        "$ cd jhc\n" +
                                        "$ ls\n" +
                                        "dir jhc\n" +
                                        "$ cd jhc\n" +
                                        "$ ls\n" +
                                        "218236 nblfzrb.mbc\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ncpchrj\n" +
                                        "$ ls\n" +
                                        "dir cnswqjjd\n" +
                                        "dir gvmlgjnj\n" +
                                        "$ cd cnswqjjd\n" +
                                        "$ ls\n" +
                                        "134879 qpzfr\n" +
                                        "30171 zvspnvfr\n" +
                                        "$ cd ..\n" +
                                        "$ cd gvmlgjnj\n" +
                                        "$ ls\n" +
                                        "209285 fst\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd qrdczsdf\n" +
                                        "$ ls\n" +
                                        "201094 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd nptwgdbn\n" +
                                        "$ ls\n" +
                                        "217555 gfprhn.rjj\n" +
                                        "66582 mrhhpr.gdg\n" +
                                        "$ cd ..\n" +
                                        "$ cd rddftb\n" +
                                        "$ ls\n" +
                                        "205347 sdwnsgwv.mjm\n" +
                                        "195976 vzgwwjq.zbp\n" +
                                        "$ cd ..\n" +
                                        "$ cd thfhbhz\n" +
                                        "$ ls\n" +
                                        "321628 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd zwv\n" +
                                        "$ ls\n" +
                                        "dir lnqb\n" +
                                        "311249 mtv\n" +
                                        "dir tnrtjrlz\n" +
                                        "$ cd lnqb\n" +
                                        "$ ls\n" +
                                        "dir vjtnjt\n" +
                                        "$ cd vjtnjt\n" +
                                        "$ ls\n" +
                                        "66715 hfm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd tnrtjrlz\n" +
                                        "$ ls\n" +
                                        "270833 jhc.vpj\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd hfm\n" +
                                        "$ ls\n" +
                                        "220753 fst.tfn\n" +
                                        "dir hfm\n" +
                                        "154659 mnzlvc.jzw\n" +
                                        "dir nblfzrb\n" +
                                        "dir nrqhstc\n" +
                                        "dir vwc\n" +
                                        "dir wlpdphhg\n" +
                                        "dir zpbh\n" +
                                        "dir zvspnvfr\n" +
                                        "160091 zvspnvfr.zqt\n" +
                                        "$ cd hfm\n" +
                                        "$ ls\n" +
                                        "dir fst\n" +
                                        "dir mfmcqhbz\n" +
                                        "dir pdblpszb\n" +
                                        "$ cd fst\n" +
                                        "$ ls\n" +
                                        "dir cpll\n" +
                                        "dir fst\n" +
                                        "dir nblfzrb\n" +
                                        "dir sbnplvz\n" +
                                        "dir vsd\n" +
                                        "307662 wlzbsdh\n" +
                                        "194873 zlnbcwr\n" +
                                        "$ cd cpll\n" +
                                        "$ ls\n" +
                                        "13452 pwcmhcf.lwz\n" +
                                        "$ cd ..\n" +
                                        "$ cd fst\n" +
                                        "$ ls\n" +
                                        "dir nblfzrb\n" +
                                        "dir rqssg\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "dir ltrc\n" +
                                        "dir nblfzrb\n" +
                                        "326613 vhwnz\n" +
                                        "244908 vzgwwjq.zbp\n" +
                                        "$ cd ltrc\n" +
                                        "$ ls\n" +
                                        "163670 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "dir brpzhf\n" +
                                        "61846 fst\n" +
                                        "66356 vccrmc.jbd\n" +
                                        "72767 vmpgqbcd\n" +
                                        "$ cd brpzhf\n" +
                                        "$ ls\n" +
                                        "224488 mttr.szf\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd rqssg\n" +
                                        "$ ls\n" +
                                        "131534 bfmhl.cwj\n" +
                                        "261143 hhznnd\n" +
                                        "dir nmb\n" +
                                        "74816 vnmwgflj.rhp\n" +
                                        "251308 wdzfzcss.fdc\n" +
                                        "$ cd nmb\n" +
                                        "$ ls\n" +
                                        "264421 fst.twf\n" +
                                        "dir jng\n" +
                                        "81009 rnt.dlp\n" +
                                        "288053 sftvd\n" +
                                        "dir vfc\n" +
                                        "$ cd jng\n" +
                                        "$ ls\n" +
                                        "8014 gfprhn.rjj\n" +
                                        "168688 ppn.qbv\n" +
                                        "$ cd ..\n" +
                                        "$ cd vfc\n" +
                                        "$ ls\n" +
                                        "dir bhgstrdl\n" +
                                        "138108 dggwnqp.fpl\n" +
                                        "303194 gfprhn.rjj\n" +
                                        "$ cd bhgstrdl\n" +
                                        "$ ls\n" +
                                        "102559 fst.nrv\n" +
                                        "269697 trqrlrw.jmc\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "dir bcj\n" +
                                        "dir cqjmmr\n" +
                                        "256392 fst.tjf\n" +
                                        "7079 gfprhn.rjj\n" +
                                        "dir gqm\n" +
                                        "dir hbqfms\n" +
                                        "dir nmgbfhmq\n" +
                                        "57962 pvdtbdj\n" +
                                        "117035 sdwnsgwv.mjm\n" +
                                        "64208 zlnbcwr\n" +
                                        "$ cd bcj\n" +
                                        "$ ls\n" +
                                        "dir nblfzrb\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "149417 zvspnvfr.dqv\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd cqjmmr\n" +
                                        "$ ls\n" +
                                        "147054 fcq.mmz\n" +
                                        "dir fst\n" +
                                        "dir hfm\n" +
                                        "110840 jcsjjj.mvg\n" +
                                        "75746 vzgwwjq.zbp\n" +
                                        "333085 zlnbcwr\n" +
                                        "$ cd fst\n" +
                                        "$ ls\n" +
                                        "114747 vmpgqbcd\n" +
                                        "$ cd ..\n" +
                                        "$ cd hfm\n" +
                                        "$ ls\n" +
                                        "dir nvvppmls\n" +
                                        "dir phpq\n" +
                                        "dir rld\n" +
                                        "$ cd nvvppmls\n" +
                                        "$ ls\n" +
                                        "dir cdsmgjdb\n" +
                                        "$ cd cdsmgjdb\n" +
                                        "$ ls\n" +
                                        "158739 hfm.nmw\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd phpq\n" +
                                        "$ ls\n" +
                                        "274026 hfm.hjj\n" +
                                        "$ cd ..\n" +
                                        "$ cd rld\n" +
                                        "$ ls\n" +
                                        "237915 hsnngd.tqw\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd gqm\n" +
                                        "$ ls\n" +
                                        "188469 vzgwwjq.zbp\n" +
                                        "$ cd ..\n" +
                                        "$ cd hbqfms\n" +
                                        "$ ls\n" +
                                        "127163 fst\n" +
                                        "$ cd ..\n" +
                                        "$ cd nmgbfhmq\n" +
                                        "$ ls\n" +
                                        "257647 gczqzbbd\n" +
                                        "dir hfm\n" +
                                        "dir zvspnvfr\n" +
                                        "$ cd hfm\n" +
                                        "$ ls\n" +
                                        "267774 gbtwdctn.drw\n" +
                                        "$ cd ..\n" +
                                        "$ cd zvspnvfr\n" +
                                        "$ ls\n" +
                                        "189769 gfprhn.rjj\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd sbnplvz\n" +
                                        "$ ls\n" +
                                        "dir bln\n" +
                                        "dir fst\n" +
                                        "dir hdv\n" +
                                        "dir jhc\n" +
                                        "31790 jhc.zvm\n" +
                                        "102276 mmmjpp\n" +
                                        "dir zdwzgnb\n" +
                                        "$ cd bln\n" +
                                        "$ ls\n" +
                                        "161029 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd fst\n" +
                                        "$ ls\n" +
                                        "333565 fst\n" +
                                        "$ cd ..\n" +
                                        "$ cd hdv\n" +
                                        "$ ls\n" +
                                        "dir zvpp\n" +
                                        "$ cd zvpp\n" +
                                        "$ ls\n" +
                                        "143723 gfprhn.rjj\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd jhc\n" +
                                        "$ ls\n" +
                                        "dir hfm\n" +
                                        "dir hnqpwnfb\n" +
                                        "dir jqgfcmjn\n" +
                                        "dir mqj\n" +
                                        "312345 psdd.ftf\n" +
                                        "dir slsq\n" +
                                        "319904 thvhdmm.rpq\n" +
                                        "317429 vzgwwjq.zbp\n" +
                                        "$ cd hfm\n" +
                                        "$ ls\n" +
                                        "249321 bwzrcghg.zwq\n" +
                                        "38324 zlnbcwr\n" +
                                        "149647 zvspnvfr.jwn\n" +
                                        "$ cd ..\n" +
                                        "$ cd hnqpwnfb\n" +
                                        "$ ls\n" +
                                        "113118 bdmtgt\n" +
                                        "299110 bthznc.bjt\n" +
                                        "$ cd ..\n" +
                                        "$ cd jqgfcmjn\n" +
                                        "$ ls\n" +
                                        "176495 hfm.wnw\n" +
                                        "333817 mqds\n" +
                                        "208755 vqsmz.cbd\n" +
                                        "298875 zltfds\n" +
                                        "$ cd ..\n" +
                                        "$ cd mqj\n" +
                                        "$ ls\n" +
                                        "186649 brfmpbwn\n" +
                                        "43322 cgdhzzl.bvg\n" +
                                        "56230 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd slsq\n" +
                                        "$ ls\n" +
                                        "dir dtsg\n" +
                                        "343453 rjgvt.sgc\n" +
                                        "313784 vmpgqbcd\n" +
                                        "$ cd dtsg\n" +
                                        "$ ls\n" +
                                        "308070 zvspnvfr.dqq\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd zdwzgnb\n" +
                                        "$ ls\n" +
                                        "dir zvspnvfr\n" +
                                        "$ cd zvspnvfr\n" +
                                        "$ ls\n" +
                                        "278754 glqszhnp\n" +
                                        "199713 sdwnsgwv.mjm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd vsd\n" +
                                        "$ ls\n" +
                                        "17978 fdrg.cft\n" +
                                        "320284 sdwnsgwv.mjm\n" +
                                        "230059 tpfmtww.jbs\n" +
                                        "168301 vmpgqbcd\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd mfmcqhbz\n" +
                                        "$ ls\n" +
                                        "dir fst\n" +
                                        "dir lwlsnt\n" +
                                        "dir mqqdst\n" +
                                        "$ cd fst\n" +
                                        "$ ls\n" +
                                        "dir cln\n" +
                                        "235621 hfm.mhr\n" +
                                        "4347 qwfwj\n" +
                                        "226297 zlnbcwr\n" +
                                        "$ cd cln\n" +
                                        "$ ls\n" +
                                        "dir cfz\n" +
                                        "dir njptzz\n" +
                                        "dir rcbps\n" +
                                        "161994 rjl.pfg\n" +
                                        "dir tcqttb\n" +
                                        "22809 vmpgqbcd\n" +
                                        "225782 zvspnvfr.gbw\n" +
                                        "$ cd cfz\n" +
                                        "$ ls\n" +
                                        "168184 zvspnvfr\n" +
                                        "$ cd ..\n" +
                                        "$ cd njptzz\n" +
                                        "$ ls\n" +
                                        "286155 hfm.mjh\n" +
                                        "$ cd ..\n" +
                                        "$ cd rcbps\n" +
                                        "$ ls\n" +
                                        "256675 vzgwwjq.zbp\n" +
                                        "$ cd ..\n" +
                                        "$ cd tcqttb\n" +
                                        "$ ls\n" +
                                        "91505 flmgglv.gjw\n" +
                                        "270377 ftbjzt.lcm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd lwlsnt\n" +
                                        "$ ls\n" +
                                        "dir ztrcwjw\n" +
                                        "$ cd ztrcwjw\n" +
                                        "$ ls\n" +
                                        "342059 vjcldgfj.twb\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd mqqdst\n" +
                                        "$ ls\n" +
                                        "326143 dhlhzzj.sbh\n" +
                                        "dir lmsbg\n" +
                                        "13108 nblfzrb.nnr\n" +
                                        "256325 vzgwwjq.zbp\n" +
                                        "146133 zlnbcwr\n" +
                                        "$ cd lmsbg\n" +
                                        "$ ls\n" +
                                        "282223 zvspnvfr.zwq\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd pdblpszb\n" +
                                        "$ ls\n" +
                                        "167164 sdwnsgwv.mjm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "161555 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd nrqhstc\n" +
                                        "$ ls\n" +
                                        "316797 gfprhn.rjj\n" +
                                        "263838 nblfzrb.cjr\n" +
                                        "dir pppmp\n" +
                                        "dir shcwlggz\n" +
                                        "$ cd pppmp\n" +
                                        "$ ls\n" +
                                        "dir fst\n" +
                                        "328237 gfprhn.rjj\n" +
                                        "288094 hzv.prf\n" +
                                        "260275 pcnhmmw\n" +
                                        "214496 pptjlrn.pls\n" +
                                        "dir tqjgrc\n" +
                                        "315647 vmbvl.zvh\n" +
                                        "$ cd fst\n" +
                                        "$ ls\n" +
                                        "4441 dtt\n" +
                                        "115073 jhdqj.tpt\n" +
                                        "337681 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd tqjgrc\n" +
                                        "$ ls\n" +
                                        "6491 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd shcwlggz\n" +
                                        "$ ls\n" +
                                        "251509 gfprhn.rjj\n" +
                                        "331578 slsnbzm\n" +
                                        "158534 wlchqtzj.ljz\n" +
                                        "341686 wmdvjs.tjb\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd vwc\n" +
                                        "$ ls\n" +
                                        "94599 gfprhn.rjj\n" +
                                        "298110 hql.hss\n" +
                                        "dir rsrfc\n" +
                                        "230201 vmpgqbcd\n" +
                                        "dir zcsqst\n" +
                                        "dir zrz\n" +
                                        "58810 zvspnvfr\n" +
                                        "$ cd rsrfc\n" +
                                        "$ ls\n" +
                                        "dir fst\n" +
                                        "$ cd fst\n" +
                                        "$ ls\n" +
                                        "259462 bflpjwd.wbj\n" +
                                        "177686 cvh.fnr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd zcsqst\n" +
                                        "$ ls\n" +
                                        "344114 bbbd.ncl\n" +
                                        "282111 gfprhn.rjj\n" +
                                        "327171 jhc\n" +
                                        "43867 qwzwmffq.chl\n" +
                                        "$ cd ..\n" +
                                        "$ cd zrz\n" +
                                        "$ ls\n" +
                                        "dir zvspnvfr\n" +
                                        "$ cd zvspnvfr\n" +
                                        "$ ls\n" +
                                        "dir fst\n" +
                                        "$ cd fst\n" +
                                        "$ ls\n" +
                                        "218902 fst.jmg\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd wlpdphhg\n" +
                                        "$ ls\n" +
                                        "dir lllph\n" +
                                        "41390 wmn\n" +
                                        "$ cd lllph\n" +
                                        "$ ls\n" +
                                        "167740 bbfqftlg.pll\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd zpbh\n" +
                                        "$ ls\n" +
                                        "63568 jhc.tfs\n" +
                                        "dir nblfzrb\n" +
                                        "dir rlsvrfrb\n" +
                                        "29977 vzgwwjq.zbp\n" +
                                        "dir zvspnvfr\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "154990 gbvpw.bpm\n" +
                                        "dir hfm\n" +
                                        "148488 jhc\n" +
                                        "301795 jhc.zlg\n" +
                                        "dir nblfzrb\n" +
                                        "115285 rvhcfsrw.crj\n" +
                                        "320034 wsqdt\n" +
                                        "$ cd hfm\n" +
                                        "$ ls\n" +
                                        "141530 vmpgqbcd\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "dir rnhn\n" +
                                        "$ cd rnhn\n" +
                                        "$ ls\n" +
                                        "46251 sdwnsgwv.mjm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd rlsvrfrb\n" +
                                        "$ ls\n" +
                                        "140923 hfm\n" +
                                        "228981 zvspnvfr.mvl\n" +
                                        "$ cd ..\n" +
                                        "$ cd zvspnvfr\n" +
                                        "$ ls\n" +
                                        "182280 gnhh.hpw\n" +
                                        "95206 vvlt.pgf\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd zvspnvfr\n" +
                                        "$ ls\n" +
                                        "234551 wsfjhlqc.zsj\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd tfsh\n" +
                                        "$ ls\n" +
                                        "dir fbrqvwgr\n" +
                                        "$ cd fbrqvwgr\n" +
                                        "$ ls\n" +
                                        "244821 nrhm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd vlsqgrw\n" +
                                        "$ ls\n" +
                                        "dir dzdd\n" +
                                        "18805 fst.rjm\n" +
                                        "50694 gfprhn.rjj\n" +
                                        "55025 jlnrm\n" +
                                        "dir pnsbfz\n" +
                                        "dir qjjjgd\n" +
                                        "dir whrtnh\n" +
                                        "28406 zggjjcct.fsz\n" +
                                        "$ cd dzdd\n" +
                                        "$ ls\n" +
                                        "dir hjmv\n" +
                                        "$ cd hjmv\n" +
                                        "$ ls\n" +
                                        "91558 hfm.qcd\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd pnsbfz\n" +
                                        "$ ls\n" +
                                        "dir bmgmh\n" +
                                        "dir nblfzrb\n" +
                                        "dir zvfg\n" +
                                        "$ cd bmgmh\n" +
                                        "$ ls\n" +
                                        "dir dvh\n" +
                                        "dir mwfbthpj\n" +
                                        "dir swqbph\n" +
                                        "$ cd dvh\n" +
                                        "$ ls\n" +
                                        "dir jhc\n" +
                                        "dir jtp\n" +
                                        "85638 rzlt.llb\n" +
                                        "$ cd jhc\n" +
                                        "$ ls\n" +
                                        "dir dltqbnpq\n" +
                                        "$ cd dltqbnpq\n" +
                                        "$ ls\n" +
                                        "133426 zlnbcwr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd jtp\n" +
                                        "$ ls\n" +
                                        "dir clh\n" +
                                        "$ cd clh\n" +
                                        "$ ls\n" +
                                        "54117 sdwnsgwv.mjm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd mwfbthpj\n" +
                                        "$ ls\n" +
                                        "75900 zwslwbr.chm\n" +
                                        "$ cd ..\n" +
                                        "$ cd swqbph\n" +
                                        "$ ls\n" +
                                        "307258 jrlljc.ntl\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "106071 zdjg.qsj\n" +
                                        "$ cd ..\n" +
                                        "$ cd zvfg\n" +
                                        "$ ls\n" +
                                        "311338 zvspnvfr.dqj\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd qjjjgd\n" +
                                        "$ ls\n" +
                                        "dir cdmwgn\n" +
                                        "dir fqmln\n" +
                                        "285733 gfprhn.rjj\n" +
                                        "dir gswsc\n" +
                                        "dir htpzdb\n" +
                                        "261929 jwc\n" +
                                        "dir lvzpqqv\n" +
                                        "dir mlc\n" +
                                        "dir mzbpmhf\n" +
                                        "329303 sdwnsgwv.mjm\n" +
                                        "76120 vmpgqbcd\n" +
                                        "$ cd cdmwgn\n" +
                                        "$ ls\n" +
                                        "dir bttff\n" +
                                        "$ cd bttff\n" +
                                        "$ ls\n" +
                                        "dir nblfzrb\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "346048 jhc.hzf\n" +
                                        "dir nccq\n" +
                                        "dir rwtddj\n" +
                                        "149890 sdwnsgwv.mjm\n" +
                                        "$ cd nccq\n" +
                                        "$ ls\n" +
                                        "141144 gfprhn.rjj\n" +
                                        "65628 hfm\n" +
                                        "$ cd ..\n" +
                                        "$ cd rwtddj\n" +
                                        "$ ls\n" +
                                        "dir jctw\n" +
                                        "$ cd jctw\n" +
                                        "$ ls\n" +
                                        "141075 thcfz.frn\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd fqmln\n" +
                                        "$ ls\n" +
                                        "282233 cjgh\n" +
                                        "$ cd ..\n" +
                                        "$ cd gswsc\n" +
                                        "$ ls\n" +
                                        "153758 ccjg.zml\n" +
                                        "dir cllgt\n" +
                                        "257967 ctqdpq.clq\n" +
                                        "117673 jhc\n" +
                                        "258604 wqcz.tww\n" +
                                        "122135 zvspnvfr.grb\n" +
                                        "$ cd cllgt\n" +
                                        "$ ls\n" +
                                        "132862 vmpgqbcd\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd htpzdb\n" +
                                        "$ ls\n" +
                                        "dir hfm\n" +
                                        "dir mlplp\n" +
                                        "231759 nblfzrb\n" +
                                        "159823 pqpbjbqp\n" +
                                        "25382 vzgwwjq.zbp\n" +
                                        "$ cd hfm\n" +
                                        "$ ls\n" +
                                        "155413 bbbsd\n" +
                                        "288638 jhhmwq\n" +
                                        "dir lnss\n" +
                                        "$ cd lnss\n" +
                                        "$ ls\n" +
                                        "341786 zvspnvfr\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd mlplp\n" +
                                        "$ ls\n" +
                                        "256802 zhcq.gzj\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd lvzpqqv\n" +
                                        "$ ls\n" +
                                        "dir cgj\n" +
                                        "dir mdb\n" +
                                        "dir shpdtb\n" +
                                        "$ cd cgj\n" +
                                        "$ ls\n" +
                                        "74595 nblfzrb.lcc\n" +
                                        "$ cd ..\n" +
                                        "$ cd mdb\n" +
                                        "$ ls\n" +
                                        "167891 zvspnvfr.ldc\n" +
                                        "$ cd ..\n" +
                                        "$ cd shpdtb\n" +
                                        "$ ls\n" +
                                        "45889 bvff.hsf\n" +
                                        "92447 sdwnsgwv.mjm\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd mlc\n" +
                                        "$ ls\n" +
                                        "7978 mrblf\n" +
                                        "$ cd ..\n" +
                                        "$ cd mzbpmhf\n" +
                                        "$ ls\n" +
                                        "38713 jhbs\n" +
                                        "$ cd ..\n" +
                                        "$ cd ..\n" +
                                        "$ cd whrtnh\n" +
                                        "$ ls\n" +
                                        "dir jbbwzd\n" +
                                        "dir nblfzrb\n" +
                                        "$ cd jbbwzd\n" +
                                        "$ ls\n" +
                                        "88613 jhc.qqw\n" +
                                        "$ cd ..\n" +
                                        "$ cd nblfzrb\n" +
                                        "$ ls\n" +
                                        "164792 zlnbcwr";
}
