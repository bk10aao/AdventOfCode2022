import java.util.*;

public class DayThree {

    private List<String> values = new ArrayList<String>();
    public DayThree(String input) {
        for(String s : input.split("\n"))
            values.add(s);
    }

    public int partOne() {
        String finalString = "";
        for(String line : values) {
            String a = line.substring(0, line.length() /2);
            String b = line.substring(line.length() / 2);
            Map<String, Integer> matches = new HashMap<>();

            for(char first : a.toCharArray()) {
                matches.put(String.valueOf(first), 1);
            }
            for (char second: b.toCharArray()) {
                if(matches.containsKey(String.valueOf(second))) {
                    finalString += second;
                    break;
                }
            }
        }
        return getResult(finalString);
    }

    public int partTwo() {
        String finalString = "";

        for(int i = 0; i < values.size(); ) {
            //rucksack one
            Map<String, Integer> sackValues = new HashMap<>();
            String firstRucksackOneLine = values.get(i++);

            for(String s : firstRucksackOneLine.split("")) {
                if(!sackValues.containsKey(s)) {
                    sackValues.put(s, 1);
                }
            }

            String secondRucksackOneLine = values.get(i++);

            for(String s : secondRucksackOneLine.split("")) {
                if(sackValues.containsKey(s)) {
                    sackValues.put(s, 2);
                }
            }
            String thirdRucksackOneLine = values.get(i++);

            for(String s : thirdRucksackOneLine.split("")) {
                if(sackValues.containsKey(s)) {
                    if(sackValues.get(s) == 2) {
                        finalString += s;
                        break;
                    }
                }
            }

            //rucksack two

            for(String key : sackValues.keySet()) {
                if (sackValues.get(key) == 3) {
                    finalString += key;
                    break;
                }
            }
        }


        return getResult(finalString);
    }



    private static int getResult(String end) {
        int result = 0;
        for(char c : end.toCharArray()) {
            if(Character.isLowerCase(c)) {
                int temp = c - 96;
                result += temp;
            } else if (Character.isUpperCase(c)) {
                int temp = c - 64;
                result += (temp + 26);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DayThree dayThree = new DayThree(input);
        System.out.printf("Part one: %d\n", dayThree.partOne());
        dayThree = new DayThree(input);
        System.out.printf("Part two: %d\n", dayThree.partTwo());
    }

    private static final String input = "TZZjzzZLfZbzgzZNNJZjwCVbwMmhwCbBpCMMBCbM\n" +
                                        "qRQPDqnWFQDtCCBQmQwmGGVG\n" +
                                        "FPllWPDPrncZsLVrgSZTSZ\n" +
                                        "RczPzRzvflVwfplrZQglmmJJDGQJ\n" +
                                        "nFbBWWFZbZtJDjmgmqqF\n" +
                                        "bnMNZWnWWHTLBBdwcCwcPCwpCSpPLc\n" +
                                        "CjpMtptpChnpMnCSGjSShMqpTVVWFFTVNVNLmHwmHLTcFnVT\n" +
                                        "fglsGJsJssBPszvddgTFVTFFFBwwTVVmHVFF\n" +
                                        "JgJrDgsPfMDhGhCRQC\n" +
                                        "PSMDSMhwmPwqDMmzrtttNQvNFmFFGFtLld\n" +
                                        "nRTCCQjcTVJJTVTbggTnFvtNdGdlFbFvbHtWFLNt\n" +
                                        "gjfTZZCRCnZJjJRRQBCBszDMPppfsPwMzfMqDsSs\n" +
                                        "LTmnZTgMmbWWGWZQZb\n" +
                                        "cHCCHHwsPtsHQtWfWjtGlWjbjt\n" +
                                        "JNQQzzPwwHsRwNSRdnnddqqvSMqMvDqm\n" +
                                        "CZFNGZfHvgfgZzFZfNfPVJMBrqVhjrrrhvvSjbqv\n" +
                                        "czlDnlcDWLnlnLQwTbqJqMwqjhVBbhJhJJ\n" +
                                        "RDQTTWzLWsDGsNHNNgpZmC\n" +
                                        "rWzbWWMWcrCbfzbwpDrQNqmqNwTNBN\n" +
                                        "FvsVggVvLGsHQHfppmwTNBfN\n" +
                                        "VGhsghvZLjPSLshgFVPGFPVJWCtMCJMflJtdJWCMcttljz\n" +
                                        "bgScSbJwPNqrQLCgLg\n" +
                                        "BzTsRVGmTDBZBwRVmzGQNZjrMCqLjWrqWNQNnr\n" +
                                        "GvdRDdzGzdvdDdmTzfwhfFlFPlbfchvlpl\n" +
                                        "JlqjMtqtSGGZjqSMlmvZZbChRRQbbPhBhCbRBr\n" +
                                        "dLfzFNVfLLzwznLdFzzwWQBQVBhWbJDrCPVBBBPP\n" +
                                        "HLgdNddfMjGJJgJt\n" +
                                        "nZHZDJHLTDnrHrbGpRrRzR\n" +
                                        "QmsBjdmBmqQzpRbZbp\n" +
                                        "ttSjjjdWvsFsmBMBfWWMMtwCNCZJvLCnnnJCZcLTvnhN\n" +
                                        "bbgngMMPfnwPmPgPDPNZMtptHzHtRRvpVHRz\n" +
                                        "rsWWhJCWqBHBNJNZpvJtzRvF\n" +
                                        "rWBrjGGsQQWlQcllCDLfwHQTDDgfQPmnDT\n" +
                                        "lWDFllmGhbWzCglHHlRHMqCq\n" +
                                        "fBtjwNwfJfZvJJBwBJZjVLNnnnMRVTzgMVVqTLzT\n" +
                                        "vJQtJrprvrbcdcpmzDDd\n" +
                                        "bmhbRmhjwddjHMGHnNtHNQNm\n" +
                                        "nBzVpgFnzVgLpFfHNGqtGfLGGNfH\n" +
                                        "BTgVVPPSPBSVlTzpzsbWhjWjnhWZlwsWZR\n" +
                                        "lBQVBBMDTMSTHHCqgLHCzv\n" +
                                        "ccWcNhtfpFvphspFcttHwwqzmdsCqLgLzLPdLL\n" +
                                        "tNjFZpnFtJNZJFfjJNpNNFjVbVDMVGRZMGlbQlQrBrbvQr\n" +
                                        "bRJtJRfRdwRBbwJzhGGcHpwrpCwDclpHDD\n" +
                                        "hSgnjPVmVVGcWVGWpV\n" +
                                        "STmFgSnPqQTjNmqJftLszfMqBhdz\n" +
                                        "WzjrRLWnlRsVRLLwtGmdhNBmbmwN\n" +
                                        "ZccgcpMfQTpgcpDDvNbtdhhhMGHtdFBNHB\n" +
                                        "vpDggvPPTvZTfTvpZcPQSZDsqrlrnRGjsrjRCrSlWRljjS\n" +
                                        "DbZfRRZfPjWDfDntnzggvgMLmVqMMmlLQjFM\n" +
                                        "NCJCCfBTThBJssSHcgFMlmMvlVHVqVgmLl\n" +
                                        "rfTJJcJrJdShscSBZbtpnPRDDdnPDRbt\n" +
                                        "zrTfLGVVLZsrsJcGJVsvQMhdlmMPfjlhlflflbDP\n" +
                                        "pCWCwRbWBgHlDhPMDPRjjd\n" +
                                        "pSggBwBCNSbrJLVTTVNG\n" +
                                        "CNCMSMgQCgQNQhfMGSGSzgfGJhchrHHwBlnJlHPqBBrHwsww\n" +
                                        "ZVWDptmTtbptpDvZWsPlwblrJPbnHcqnJwrP\n" +
                                        "pRFtWZVVpVWWZVWtQLzsLQMLzCfFsGgz\n" +
                                        "MlcpDmgWNlPqcmmqmcgcPdNDRjhLSRRVLjRRShGFjFWRSLLW\n" +
                                        "bwQJnzbzJTbvMJSHhGGHRjzLGRjR\n" +
                                        "wZbBwwQvtbtQtBbnvJwbCnwmsMpNcccgDmdPcsqqqsDqCc\n" +
                                        "zMhMnRbZMpCblpzLlhJPRjDFcQPtJQPcDdWj\n" +
                                        "mNSGvgdSsBGwwNDvWtQJWjJWPHFF\n" +
                                        "GmdgGdgfqqNBgVGrbCMhrMfLLflhpL\n" +
                                        "PVHHPMLMgLQSLLsnHBCZfhzpRfhTpdRppSfdZf\n" +
                                        "rgmWvWgFrmGlZGGfphhpZG\n" +
                                        "bJgDFqFcmmWDJWbvJFtMCPQsHPHBVPVCQPcCsQ\n" +
                                        "VJJHNNmtGqRmMVVwRfTCRfnQpFTFnF\n" +
                                        "vSvjSvbBzvldhcGwGffFCQCwgrFd\n" +
                                        "jLhhlGjvczDhLSlDWjLzctHMZtJtHmqHJZqWmVsMqW\n" +
                                        "LhchvRJtHzhdTTdJjQLQjQVVnjSmLMLQ\n" +
                                        "NFpClSPqwqNgPPNPNglllrBQBrQVjQjmBQnfBfjQjC\n" +
                                        "wWGGpSwSZNpNPFDwPDDhzDdvbvJzHHJbhtzv\n" +
                                        "gtFtNNmlGzQtNPttfDMwwfbbMR\n" +
                                        "LVcBjsBjFJrLFWVrBrMbbMSSPpDPPqVDfpPb\n" +
                                        "JrCBnsdWJJrHZdFmGglmmg\n" +
                                        "BmCCWSLmWsmtCCSppSmmpcpRfMZjjBgJJGGjBwZfgjZjFwJw\n" +
                                        "TPTPnTPrPVvQTTzTVdPMrJJZwggjfHwJJgjHZrJFwH\n" +
                                        "NQvvNnQPDPhNcstcStDMWWWS\n" +
                                        "hntthHVQVbbbSzgjgZjngjRD\n" +
                                        "TTvJJCldFJTvFFTBFlpTzvvsRgZWGWSLGrlWWRSGLjRGjRDL\n" +
                                        "TzCcFcvcsCmqPMQwQPcwPM\n" +
                                        "DltVvVLvbGPDhjRhhjSZjSSL\n" +
                                        "CffszNzssHCCqJjJnqRnpgRpZB\n" +
                                        "CszNWdsfDWtZwwDG\n" +
                                        "DdbmddmzDDNbsqzvzmdzsdsRJLjqtVWWjWJBBVBwVjWJtB\n" +
                                        "CnFPCcCcPFFFGffjjCWBVwwtRwNwCw\n" +
                                        "QNZlphpNDpHsDrvg\n" +
                                        "gdHSCbCTGgQbtNLvgrjwNMMwrr\n" +
                                        "BnzVRHFZVHvNhNRNMMhW\n" +
                                        "zFzFcnlZPHlbQdlT\n" +
                                        "GmddjTrgFgmgWGmFvmmmFFfwSCVpwHVrHpwhwrpCBfBC\n" +
                                        "tctRcRRCMtsMsMDPlDtDbMzbQJJbhwHVQJhBHJVQHBbpfB\n" +
                                        "tPDDtcnRRqzzcCzLPMLPRddWTdqgdZqZTZqdGmjFWv\n" +
                                        "sWvfGlGqsSggNcNcmf\n" +
                                        "JBwwVccFJtrzpMwtrMMMLTnNnJngJgQNSgmTJgLN\n" +
                                        "wtPMHrRrBwtPVRHrrHVPZvqDWWWcsGsvqDlZZd\n" +
                                        "jBjBBJRhCJbjffCjWlDfmbFQmZFgPpmmgpmbSSQF\n" +
                                        "dsqGrttGhswQmqpFFqQw\n" +
                                        "THdsdrdTHzLLdLTsTdtHNshlDffDCHJDjfBcBRlJRfjV\n" +
                                        "lDNlPBQlccQttcNBcDPvFFJmdTwtFJFdTdFgzg\n" +
                                        "bCWMLfpZLZLVhMbGLLsVzTwmhvTgSJHwHdTvSFSwJJ\n" +
                                        "RCZZVZLZWLRZpZsfpVsscjzQRRPQcPcDQzPljzPB\n" +
                                        "tVfCLfRVCGTRCPtRMPftHGqpnnqpdzqNbHGdqzHd\n" +
                                        "DlDlWmvDWsWJmMmmsWvWDlSHzHpnpbNqnbnrppbbpprJdd\n" +
                                        "DvhWDFBhvslFSDFPVPVBfgwgfCtMLV\n" +
                                        "FtlLQqlDnMmFJRPM\n" +
                                        "hwlpwBphHplpdHfZnjRRjMmCgfPZgJ\n" +
                                        "BdpwvzcNpBrDbLTslszG\n" +
                                        "RjPhcnNzRcLcFlsFNlFRfTffdhJhSTVqqSdDMVMf\n" +
                                        "ZWtZgrgPCvrbHSSfMqJTDWpdMf\n" +
                                        "vBvHgCmgHtgvtrHbwcLjNLNFcnPBNcPLQQ\n" +
                                        "FZhtMtddjCGQSVjmjC\n" +
                                        "qbvcnvPqBWcPVVCTCmSQLVCq\n" +
                                        "vVBVzBNpDNhgdZDg\n" +
                                        "lNVtllQFQVnQNrZpCtQCdZZjSbfRbcDjZqSfTqDffJ\n" +
                                        "HzBJBvPJLWHvwmBwHWRsbsqfbSbzbTbTTRDs\n" +
                                        "vLwPHLLMGHwGBWBHLvBgBVCgrQQpdprNVttQJrpQdQ\n" +
                                        "TbZDQlZDCHjwtbjnRSTRTPPTBWWWPB\n" +
                                        "GhpgpLJFcvgcMRqfBBmSQggzWq\n" +
                                        "LcFQpGdGsrjDDDHssl\n" +
                                        "qzpPgTpnNWRfTBBCWf\n" +
                                        "rLFsVcFltVBfdGClPdGf\n" +
                                        "vmtZvwsZrLFFFrPDqzDvjzDqJMjv\n" +
                                        "lDlzzsMPDssjsSGTjlTTsqbbftfqNwJNfHqqbfDmbW\n" +
                                        "FFgpFndhQLnhnLRpQCLnVrgtHttvfqJmNbqWWbJHNHtb\n" +
                                        "pBFrVVrmZGSBBZsz\n" +
                                        "bGMfcMCPPCtcLqPLCRqPZnjLVTdnjjWsVLHVlllVVL\n" +
                                        "SwzDBmzgwFSFQzvgBrgvwFdVHjHwWHJsjnVsTWVHHWHJ\n" +
                                        "FFrBNpQWpFrgFSmmSpQmrQQNZPPRRbfGMqCGcCPGtMqqcZ\n" +
                                        "PBhcVpBRPcqHfnjRRJJl\n" +
                                        "GsMrsGTszsrMdnsGZmzMsCfDtvHfHqvjJlvdqfHflvtq\n" +
                                        "gmrGMGGmGgbmsrrCThnBFSQSFVFhSnVcpg\n" +
                                        "QCDnqdqVPswpJZMLLCHZMJ\n" +
                                        "RhchlRBRWlLmZzVWVJGV\n" +
                                        "VrhfhhBgTcRTVhdDFwdwqTDnnnjw\n" +
                                        "jVsSsLjJJmSLlmJSlPthrhHZGthLpZLdWZ\n" +
                                        "nqFTFNbRfnDCRzfnzqPBpGcdGHttWHdcZGRrtchh\n" +
                                        "bqNzTTbFTnwnTmPjvwsVgQVjgl\n" +
                                        "BBlNWWMlVWQlLPNjVLWWGMQcJCscFSmwRCSnCFJscwcw\n" +
                                        "bbHZHvHpHgrqSCcwvSsFFRsv\n" +
                                        "wwbhdfdwZlWljdtNdW\n" +
                                        "NmlnhSNwzjjswNvqqqbjgddqtgVt\n" +
                                        "TQMTMrFJHDFTFBrTMDMQDQgdnCVggtpLpvggnQdvdQ\n" +
                                        "fJPJHrFZFBHTDPrTJHZrFswsWnWGmmGNlwwlRsmSZN\n" +
                                        "bdntqdNMQCtcnnbqtNtcgQWWjjFDjhSBSjJDWSfDFWBc\n" +
                                        "RwsZzRvZQPQsGPWjphzpfjfBffzf\n" +
                                        "GPsrRQvvQlwlMnHHlTgMNT\n" +
                                        "TnnnQTLnBPQMRMpgGRLGwp\n" +
                                        "VNcvvjjVczRRjsZvvqgmpMGwZWZmJSqwwW\n" +
                                        "tzvsdrsVdFndRDbdbC\n" +
                                        "qSfbWlZVPdWmmcjvjjwrcwQm\n" +
                                        "TpTTpPJzTBnNsshnnTsctLwjvQMzrLrjjFMtjv\n" +
                                        "NPsNBhNJhBJgNnqSSZlSdVgVGqdq\n" +
                                        "pQsgcsdSpmsJctQhrhqDHPjrjNQH\n" +
                                        "VVGGbfvvMMBZPjjHqVVrTjmC\n" +
                                        "fZbfnRLBfbZGblbfMZnBGZFlzJcRdttwtJtdzmdswcJJdpRs\n" +
                                        "TDqDqTZFFqDqdDvSMwtCbjbFjbmGGwCffG\n" +
                                        "hQQnchQZpQzCfmGtblfLhw\n" +
                                        "RnNpRPrcpsRsVWHSDZSqWrDJ\n" +
                                        "gLqgTfgwTCwmgWWrfCcRdvBCGGBZjGRvvZ\n" +
                                        "MFbPMPnNzFbssQFpQNNScQSdjvBBBSRllBvZvc\n" +
                                        "sHMHpzsJnpNMNnHsnMJbWLVwmwgVwDdDJwgDffrJ\n" +
                                        "QGdbSLSzBVbGRQrJfllDbnfpJfltJl\n" +
                                        "ZMwPCFPwPmFgCFvZgZmcFwcPhJnphhscQnJhJnsptnDNthts\n" +
                                        "PHZgCmwggvMjZFWjFvQTBzRGHqSRRTdRVGGQ\n" +
                                        "zJRppmjPMCjJgtBQWtZZgPtg\n" +
                                        "tTFsltFtVGWnllQBnn\n" +
                                        "swLfbFSvsmJCCSRCRt\n" +
                                        "MZVRQzMwfRQgQQDvncrvrSHHdSfS\n" +
                                        "tWWBhJbhnBsWCWCGdDbvSpvDpcrrcqHq\n" +
                                        "NBTCBJsCTFJFjzjFMwnzLR\n" +
                                        "RBhlNZsgrZNdbfrrmFGbjb\n" +
                                        "ztJLFLzLQDtnnCLLCzSTwzJmqmGGjddPmSPPmGjpdqGMPj\n" +
                                        "JcLLFVtLJDTQCsZgscvlWBZHgv\n" +
                                        "hznggMvgwwPCDwhnCMWsDlHjtJPjtjrZlljtPJjZHt\n" +
                                        "mvvGVVcvHJtppGpS\n" +
                                        "bVQvQLfRRbfFFwhMsFshsqsFzM\n" +
                                        "BBRWFZHWSGRZvQtQRpRtHHBjTTcqhzfnBcfzchjTTnhncT\n" +
                                        "PbwdVMbmlDZmNPTfjrcfnzjf\n" +
                                        "sMVLmsdmldLVmJLCDHFgSJgZSSGHtFppFZ\n" +
                                        "SGwFSCvtwjjDvDGDCjjDCNRnzbbnpnBppHBNhbbTpqbB\n" +
                                        "rBBllQlgslmnmbzqRm\n" +
                                        "scQsLMZsPMVfMrFwBZtvvCWFtJwS\n" +
                                        "nlhLFFSggjMnLnLHTPlMTSBfRzrMQBCBCRDDdCdQrzWr\n" +
                                        "ZwFcssmNJqNNcZGFzdBrRZCDCdCffDrR\n" +
                                        "mwbwGNcwwpSjPlFgpPlH\n" +
                                        "HsvNvddbZJDDsNbDqvsqNsqnjtllczmjjbBjzjQzjlncnc\n" +
                                        "VTCTPGhpwGLfChfGCpTrnrgQrlntrQGQcrcgQr\n" +
                                        "WpPfLTPWPhMPhwCNdStvSdWHHWHDdH\n" +
                                        "hjtjnnbLMCwCMhbgfJpfDZpSsGHDHNSmsf\n" +
                                        "BqBQBccqFrWcPTWdWTcHHNHJpsHpmDDsHHSFSD\n" +
                                        "QRcPzqWzzzrdzzWvTqQcBcRgnhmhmCbnhtvMmggbLLgLvg\n" +
                                        "zdTNLLdRdTPFFJFllQSzwJ\n" +
                                        "mhmBmBBjtjhHmjvvBhvthThnFwQwwSnWbGwlQbQtnnGJtS\n" +
                                        "cTvHTgjCmVHZgHvhHHdRfMddfLsrRfZNpsPL\n" +
                                        "lfLnsHhHJBBfBGrBpS\n" +
                                        "VPjqqwVVqNjqQVVCVPNNVQpGpmppcBcDmGmpsmsDsCrD\n" +
                                        "QdQNFwQdvjvRqFFqvRPqLgngshhRJsLnHLWgLRhh\n" +
                                        "dwRwQVNwwJQNnnhmBtZZdCZhFBrP\n" +
                                        "MMHTvMjsWlmhhBrrrlhm\n" +
                                        "jWTcWWDWsWMTgjMGsHvGGMsnJzVNpRQQDDpbJVbnnwNrnV\n" +
                                        "NcRvJCGnWnNMwtMPlMMF\n" +
                                        "rqRLrVmTrjjRmBqjQLrjzZgMgDHltVPMgFbMFDbPwMwH\n" +
                                        "fzjrZQSQzBjnvfnsJcGspR\n" +
                                        "fHPFZPsmffftTpsTqJGhhDjC\n" +
                                        "bbBdcbcwNGzzbNdBdcNQqJDDTJhDCNjQpRRCJT\n" +
                                        "VcWBbgBMWbMdzPmPtGWZmLWPFv\n" +
                                        "zDWFvgCCvWDgVVmrZppPbCPZ\n" +
                                        "wdqsBhcMdbJJmlBgHg\n" +
                                        "hTwTQgLNMTsQstjzvSTTWjvfRW\n" +
                                        "vGGwWsvjpsCShrjTCCrj\n" +
                                        "CmMCZCtqzmMzNgZgdZzSrzPFrThnrPPHTcrSnH\n" +
                                        "VVMtQZdgZqLtqLZVMffwwDRCLGWlCsJvwpwlRv\n" +
                                        "fJfhpVVzMpgczZSqSSnZ\n" +
                                        "NvPNvRsmNCRsbsvNbhjqgcDZSqSFFmgGGnZZDg\n" +
                                        "TChvRBBRPsJLTMHMQfwV\n" +
                                        "CvNPsrfrjvwwfsjwsrNlgDzzBmgmNhlNBHgg\n" +
                                        "JVmdMJmcMTSqVlnlnnzBHBGg\n" +
                                        "SmLqSSWqbcbbWqJqqFcTJfPwPwtwWCfrrPrsQvQZZf\n" +
                                        "hMRnnvfRntfvcGqccDqhHlSLSgjGLWlLHlWPgWPS\n" +
                                        "bJsssbJFCZsQCsdQFzJWwSPSdSgdWwvwmHWWmj\n" +
                                        "QBQbTzFzrrzTTtfvffcfqTDM\n" +
                                        "fdcRNRvdNwczRFLcvNvzRvDSjhlmhclShjSnmMlSmDSS\n" +
                                        "VtJqbCqqVCfQqVpJHqZfmGDhgmjlMHmDllmggShG\n" +
                                        "qqtqTpVqJpVPZbffWTNfwzvRrFLL\n" +
                                        "mmhccmZGNcNhWNmDDGCmvlLWjpjbJRSpdrnzzbRzSjLJpJJz\n" +
                                        "BQHBgtZQqwTTtfndpSJJbJfbjjRp\n" +
                                        "THFVBZqQsqTgwtswWWlMclMDNlNclVVM\n" +
                                        "GPmLbhQmDbbDHfpCQCfdCfTr\n" +
                                        "SlWVScMgpzFSjgSMtBjTrNNdrfjrHrBd\n" +
                                        "ZzzsWWnzWFcsRqpJmPhqsw\n" +
                                        "cfNQdfdRcNHNFcqRcqqdWmLQgMwwMssLggpLLsmm\n" +
                                        "rTtGGhBTJSThwssmgssGzpHC\n" +
                                        "VbTTlJvVHbBJthtVbrJRdFnjljqZdfPqPnRdFN\n" +
                                        "tLtpstBLtzPnQBtFBtMpnpQPhmGGRRhMhGNRRCCmRJmmbvNJ\n" +
                                        "ffflfqqVVHllVHDVNVZHlTDGSGbGSvhmvTRCCSTjShShCv\n" +
                                        "DldDlZgWcDdfDZggfddccsnzLWsnNwPFQzPBwLwzzF\n" +
                                        "FpRCrNpMrCpNRZCrsCpZrCpqvmJnvnLPBwfvfmvzBJnwswBw\n" +
                                        "DbbVStQgdbJmLbJm\n" +
                                        "SHlSShlhSHHWcWlghFMNqcRqcZrFpFppTJ\n" +
                                        "QFPnsjqjtQPWfCZZlZbT\n" +
                                        "dwrMzzWRVWJVDDlfDlrfDlhl\n" +
                                        "BNzVdLWwRNmzwWBRVBVzSQQLtnnqSqssFvtQFsjL\n" +
                                        "TGfDmTcCMMmDsCspRbCCbsMJvWPvSSjZSwhFwwFgjPJZwG\n" +
                                        "NNHLHBNHrgVFFjJwFJZLhv\n" +
                                        "BzzqQQnVtrdnVNrtVNBlppbbDCRmdfggRCgmTscf\n" +
                                        "rmbcvbRbzrsZZCCNQjwdgRGjwGQGLVML\n" +
                                        "htDnDtHWnWPjVHQdgdNwHg\n" +
                                        "PFFTlhllffsNsscl\n" +
                                        "hFSlSlShLppwNlwH\n" +
                                        "fjSvvfbzBfDjPQvBDqjfsBGdwwLppMHmmHHHbNNwGnmG\n" +
                                        "SqzVBZDPPDQVFWgrWJTtCg\n" +
                                        "ghlqSlFhCFRgFsssSqjhlsVsvNPtcNdndctVzdzJPndQPnJd\n" +
                                        "TwfBmZmLwLZDfWZTbGQPtvzJzdLNcLdrQrcL\n" +
                                        "GmGwDbZHbmpBmwBWmGDCpvShClvSjgMjRpMqjv\n" +
                                        "vDDQpzjbqDQDmJvmRFBgNdWcQtdcHcctWcdN\n" +
                                        "hTfsLlSMCCSCfGCPlhfnGtgBcBHBdgLdVttvNtBBdg\n" +
                                        "lZvlfPffnZSnMzDjzzmZzDbwqq\n" +
                                        "cwgNgWWNccLcHnLGnnHD\n" +
                                        "JRrPNPNlGHPDtzLv\n" +
                                        "jmBJljNljRZZbpQZBgZp\n" +
                                        "WWcWLtwHcHLwWRwPWDwZGrCMvvFvZnDrvF\n" +
                                        "JVVmdbZmCvzGCvzm\n" +
                                        "ZQgdjVgdjQhJZQbhblbNQqjJLsPSsppscPPWhhWtSctpHsHs\n" +
                                        "fZtsGZsQQtpFrLqZrLQGZfHmdBjSMNmmRNddbFcMcbmBcc\n" +
                                        "vnwnlhlTWllgnJVTTgDTnvTwdcjSbRdbHMdcMMNdVdBNjRHj\n" +
                                        "zDvHnPvTwhnDDCZpLLftqzffst\n" +
                                        "hdCvWvQQlvlZzgCcGgjCPSLC\n" +
                                        "HMTHMDRRtmBNtTRDrRmmPcjGPPrdSzcLjjzdfzzL\n" +
                                        "tqMsNmmVMTNmtMHbZbnJdblZnlwWbV\n" +
                                        "bzQNPzMbVrfPfLrjrj\n" +
                                        "ZvZnzsTmnlnTWnJTvSHSsJDvBrdwwwLBtjrBBRtjwHqqrfLf\n" +
                                        "zpWDWSnnTnJmDzSMNchQcGNMQpQGGN\n" +
                                        "McCNssGmscnNmmsNzLwwLTSTRBJBBZLFTz\n" +
                                        "WTbhQbfPvWThFwFWJHBZWwLH\n" +
                                        "jThbtbPjvDDvDhqjppdcsgcGGcMmNlNldtNt\n" +
                                        "VsRLrPMPrrNRRDMDNsDMRdGCdGGZZZwljjCCjHCHQwcG\n" +
                                        "qhmfBgtqlfqzfTtggSWwbHjcwGjjbwwcTQCC\n" +
                                        "lnSfStzhvfvzFgvqsLJLrpPpFsRsMNPP\n" +
                                        "mFfWmmTbcFNFZWbcCftLCsCLGLfCGqGV\n" +
                                        "DQQMlJhjGqtswZDD\n" +
                                        "BpBhQSSQRSljRJRvQllnTWNHrWccHrNppbNZWp\n" +
                                        "llSWcPmCDRCSmjPTCCSPHtLrfJnwrJfVBRfJwrqB\n" +
                                        "FFFgdFdpGVHtVGwBtn\n" +
                                        "gMbbsNdvbsQgppppvvszvzWTTTlMCnlPDjTlDCWWccmC\n" +
                                        "fzMlGqVMwzSSPNRBrRZrFrFRGZ\n" +
                                        "blnlQnlWFZbmFbHr\n" +
                                        "CgttsQpstcCtnslqfjhPhVzMgMPz\n" +
                                        "SrSHtjrJQZjBpvNctmnRvnDm\n" +
                                        "GWPlhPqFfPsGwCqsnsGszWGwNdMLpRvLmRNcNpmRmvDfpMLM\n" +
                                        "GPCWWWzbbzqPnnCbPZHbQrQrQgVBVJJVJV\n" +
                                        "ZVhCwqvFZVpwdhLdqLhtvcGBcSNLRSRBGRBNGNSSmN\n" +
                                        "lTjnlnjgslsjJTgrMrQQjjTSGSpcGRSmDBNSNJcDSBbRmS\n" +
                                        "zMrjllgnPrlrnlWrQgTgzgvwqpFwZHChHvPwCtVptCVt\n" +
                                        "RTjjznsTsnnrzRrmTmrNNCMhwMrCNNCwWhCMGN\n" +
                                        "DvScpDDVfBPqVcSbDpbfHpqwCWGJCwCJhvFdFFwlMGJWCG\n" +
                                        "fhHPbhZSpDbDTmsTZTjRzzQz\n" +
                                        "QbVQvNrrdFcbcMvvdNrcGrrczPnPplPnfnpzwpgmlflRVwwP\n" +
                                        "jBHLRqZWtLLqWDhBLshBCLsHgpfftfPmmpfpwnwfwJgfpfPn\n" +
                                        "WCRhsLDsDLBChTLWHChFTTMdGTQGvGQcMQNGMd";
}
