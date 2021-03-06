import java.util.LinkedList;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    String[] wordList = {"able", "ale", "apple", "applebees", "bale", "kangaroo"};
    String givenWord = "abppleebeesgf";

    System.out.print(longestSubsequence(givenWord, wordList) + "\n");
    System.out.print(shortestSubsequence(givenWord, wordList) + "\n");
  }


  /* This method finds all subsequences in a given word from a given string of words */
  public static LinkedList<String> findSubsequence(String givenWord, String words[]){
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
    return subSeqList;
  }

  /* Finds the longest subsequence by calling findSubsequence and returning the longest result */
  public static String longestSubsequence(String givenWord, String words[]){
    LinkedList<String> subSeqList = findSubsequence(givenWord, words);
    String longestSeq = "";
    for(String word : subSeqList){
      if(longestSeq.length() < word.length()){
        longestSeq = word;

      }
    }
    return longestSeq;
  }

  /* Finds the shortest subsequence by calling findSubsequence and returning the shortes result */
  public static String shortestSubsequence(String givenWord, String words[]){
    LinkedList<String> subSeqList = findSubsequence(givenWord, words);
    String shortestSeq = "";
    for(String word : subSeqList){
      if(shortestSeq.length() > word.length() || shortestSeq == ""){
        shortestSeq = word;

      }
    }
    return shortestSeq;
  }
}
