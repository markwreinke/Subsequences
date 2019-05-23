import java.util.LinkedList;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    String[] wordList = {"able", "ale", "apple", "applebees", "bale", "kangaroo"};
    String givenWord = "abppleebeesgf";

    System.out.print(longestSubsequence(givenWord, wordList));
  }


  public static String longestSubsequence(String givenWord, String words[]){
    LinkedList<String> subSeqList = new LinkedList<String>();
    for(String word : words){
      int givenIndex = 0;
      boolean isSubsequence= true;
      for(int i = 0;i < word.length(); i++){
        boolean foundLetter = false;
        while(!foundLetter && givenIndex < givenWord.length())
          if (word.charAt(i) == givenWord.charAt(givenIndex)){
            givenIndex++;
            foundLetter = true;
          }
          else {
            givenIndex++;
          }
        if(!foundLetter){
          isSubsequence = false;
        }
      }
      if(isSubsequence){
        subSeqList.add(word);
      }
    }
    String longestSeq = "";
    for(String word : subSeqList){
      if(longestSeq.length() < word.length()){
        longestSeq = word;
        
      }
    }
    return longestSeq;
  }

}