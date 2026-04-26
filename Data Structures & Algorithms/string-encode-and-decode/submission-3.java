class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length());
            sb.append("$");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            int indexOf$ = str.indexOf("$", i);
            int size = Integer.parseInt(str.substring(i,indexOf$));
            res.add(str.substring(indexOf$+1,indexOf$+size+1));
            i = indexOf$+size;
        }
        return res;
    }
}
