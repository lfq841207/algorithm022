class Solution {
    public boolean lemonadeChange(int[] bills) {
        return subCall(bills, 0, 0, 0);
    }
    public boolean subCall (int[] bills, int idx, int count5, int count10) {
        if (count5 < 0 || count10 < 0) {
            return false;
        }else if (idx >= bills.length) {
            return true;
        }else if (bills[idx] == 5) {
            return subCall (bills, idx + 1, count5 + 1, count10);
        }else if (bills[idx] == 10) {
            return subCall (bills, idx + 1, count5 - 1, count10 + 1);
        }else {
            if (count10 > 0) {
                return subCall (bills, idx + 1, count5 - 1, count10 - 1);
            }else {
                return subCall (bills, idx + 1, count5 - 3, count10);
            }
        }
    }
}