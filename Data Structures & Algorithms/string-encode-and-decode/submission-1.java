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
            int lenOfInt = str.substring(i,str.indexOf("$", i)).length();
            int size = Integer.parseInt(str.substring(i,str.indexOf("$", i)));
            res.add(str.substring(i+lenOfInt+1,size+i+lenOfInt+1));
            i = i+size+lenOfInt;
        }
        return res;
    }
}
