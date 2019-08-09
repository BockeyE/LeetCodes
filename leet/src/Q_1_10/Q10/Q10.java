package Q_1_10.Q10;

/**
 * @author bockey
 */
public class Q10 {
    public boolean isMatch(String s, String p) {
        if ((!p.contains("*") && !p.contains("."))) {
            return s.equals(p);
        }

        int sp = 0;
        int pp = 0;
        while (sp < s.length() && pp < p.length()) {
            if (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '.') {
                sp++;
                pp++;
                continue;
            }
            if (s.charAt(sp) != p.charAt(pp)) {
                if (p.charAt(pp) == '*') {
                    sp--;
                    if (p.charAt(pp - 1) == '.') {
                        if (pp + 1 >= p.length() - 1) {
                            return true;
                        } else {
                            while (sp < s.length()) {
                                if (p.charAt(pp + 1) == s.charAt(sp)) {
                                    break;
                                }
                                sp++;
                            }
                        }
                    }
                    while (s.charAt(sp) == p.charAt(pp - 1) && sp < s.length() - 1) {
                        sp++;
                    }
                    if (sp >= s.length() - 1) {
                        return true;
                    }
                    pp++;
                    continue;
                }
                if ((pp < p.length() - 1) && p.charAt(pp + 1) == '*') {
                    pp = pp + 2;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return sp >= s.length() && pp >= p.length();
    }

    public static void main(String[] args) {

        System.out.println(new Q10().isMatch("aba", "ab*.c"));
    }
}

//"aaba"
//        "ab*a*c*a"