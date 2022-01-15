public class RadixTree  {
    private Node root;

    /**
     * Simple constructor - takes in no parameters
     * Sets root to an empty string node
     */
    public RadixTree(){
        root = new Node("");
    }

    /**
     * @param data is the string that will be added in the tree
     * @return void(nothing)
     * 
     * The insert method breaks down into one base case, and 4 other cases
     * which I've labeled in the code. The most important variable is "index,"
     * which tells me which node or "path" I'll need to go down to in order to 
     * add the data.
     * This method works recursively, cutting down "data" with each iteration. 
     * 
     * efficiency - O(L)
     * L is length of word being inserted
     */ 

    public void insert(String data){
        insert(data, root);
    }

    private void insert(String data, Node curr){
        int index = charToIndex(data);
        Node next = curr.arr[index];
        if (curr.arr[index] == null){
            curr.arr[index] = new Node(data);
            curr.arr[index].flag = true;
        } else if (data.length() > next.data.length() && data.substring(0, next.data.length()).equals(next.data)){
            //first case: word is extension of prefix
            insert(data.substring(next.data.length()), curr.arr[index]);
        } else if (next.data.length() > data.length() && next.data.substring(0, data.length()).equals(data)){
             //second case: prefix is extension of word
            String temp = next.data.substring(data.length());
            next.data = data;
            insert(temp, next);
        } else if (next.data.equals(data)){
            //third case: words are the same
            next.flag = true;
        } else {
            //fourth case: mismatch in word
            int count = 0;
            while (next.data.charAt(count) == data.charAt(count)){
                count++;
            }
            String repData = data.substring(0, count);
            String addNewData = data.substring(count);
            String addOldData = next.data.substring(count);
            next.data = addOldData;
            curr.arr[index] = new Node(repData);
            curr.arr[index].arr[charToIndex(addOldData)] = next;
            insert(addNewData, curr.arr[index]);

        }
    }

    /**
     * @param data is the string that will be removed
     * @return void
     * 
     * Delete also works recursively. In the public method, it simply sees if the
     * tree contains "data" and goes to work if it does.
     * To locate the correct node, it cuts down data each time, similar insert.
     * Once it finds the end node that we want to delete, it tests to see if the data
     * is equal and if the node is flagged as a word. If it is, it will set the flag 
     * to false, which fake removes the word. The only time I need to delete the node is
     * if its a leaf, which I do on the first iteration back through the recursive call. 
     * There are two cases where nodes need to be smushed together, one is when the node 
     * with the deleted data has a child, which I deal with in the base case, and another 
     * is when after deleting the leaf node, it's parent node ends up with one child. 
     * 
     * additional comments in method
     * 
     * efficiency - O(L)
     * L is length of word being deleted
     */ 

    public void delete(String data){
        if (contains(data)){
            delete(data, root, null);
        } else {
            System.out.println("Tree does not contain: " + data);
        }
    }

    private boolean delete(String data, Node curr, Node parent){
        if (data.equals(curr.data) && curr.flag){
            curr.flag = false;
            if (curr.status() == 0){
                //deleted data is leaf 
                return true;
            } else if (curr.status() == 1){
                //smush case - deleted data has child
                int index = charToIndex(curr.data);
                int count = 0;
                while (curr.arr[count] == null){
                    count++;
                }
                curr.arr[count].data = curr.data + curr.arr[count].data;
                parent.arr[index] = curr.arr[count];
            }
            return false;
        } else if (data.length() <= curr.data.length()){
            return false;
        } else if (curr.arr[charToIndex(data.substring(curr.data.length()))] == null){
            return false;
        } else {
            boolean test = delete(data.substring(curr.data.length()), curr.arr[charToIndex(data.substring(curr.data.length()))], curr);
            if (test){
                //delete leaf node
                curr.arr[charToIndex(data.substring(curr.data.length()))] = null;
            } 

            if (test && curr.status() == 1 && !curr.flag && curr != root){
                //smush case - node is deleted which results in parent with one child
                int index = charToIndex(curr.data);
                int count = 0;
                while (curr.arr[count] == null){
                    count++;
                }
                curr.arr[count].data = curr.data + curr.arr[count].data;
                parent.arr[index] = curr.arr[count];
            }
            return false;
        }
    }

    /**
     * @param data what string to test for
     * @return boolean for if its there or not
     * 
     * Contains works by recursing to the right node, similar to delete and insert.
     * It simply tests is the data is equal and the flag is true, then returns true/false.
     * 
     * efficeincy - O(L)
     * L is length of word
     */ 

    public boolean contains(String data){
        return contains(data, root);
    }

    private boolean contains(String data, Node curr){
        //System.out.println(data + ", " + curr.data);
        if (data.equals(curr.data) && curr.flag){
            return true;
        } else if (data.length() <= curr.data.length()){
            return false;
        } else if (curr.arr[charToIndex(data.substring(curr.data.length()))] == null){
            return false;
        } else {
            return contains(data.substring(curr.data.length()), curr.arr[charToIndex(data.substring(curr.data.length()))]);
        }
    }

    /**
     * @param prefix - the prefix that needs to be added 
     * @param curr - the current node
     * @return String
     * 
     * The toString works by iterating through the array of each node, then making
     * a recursive call for each one, until it reaches the base case of each node. 
     * The prefixes of each node is added until it reaches a leaf, and if the flag is true
     * it adds it to the toString in a new line.
     * 
     * effeciency - O(n)
     * n is number of words in tree
     */ 

    public String toString(){
        return toString("", root);
    }

    private String toString(String prefix, Node curr){
        String toReturn = "";
        if (curr.flag && curr.status() == 0){
            toReturn += prefix + curr.data + "\n";
            return toReturn;
        } else if (curr.flag){
            toReturn += prefix + curr.data + "\n";
        }
        for (int i = 0; i < curr.arr.length; i++){
            if (curr.arr[i] != null){
                toReturn += toString(prefix + curr.data, curr.arr[i]);
            }
        }
        return toReturn;
    }

    /**
     * @param none
     * @return string
     * 
     * This method prints out each individual node that's stored in the tree,
     * which is usually less than the number of words stored. It works similar to 
     * toString, except it adds every node to the "toReturn," instead of adding
     * the prefixes. This method helped alot with testing.
     * 
     * efficiency - O(n)
     * n is number of words in tree
     */ 

    public String nodePrint(){
        return nodePrint(root);
    }

    private String nodePrint(Node curr){
        String toReturn = "";
        toReturn += curr.data + ", " + curr.flag + "\n";
        for (int i = 0; i < curr.arr.length; i++){
            if (curr.arr[i] != null){
                toReturn += nodePrint(curr.arr[i]);
            }
        }
        return toReturn;
    }

    /**
     * @param data - string to be converted into an index
     * @return int - the index
     * 
     * This method takes the first character from the input,
     * makes it lowercase, and uses the ascii table to convert
     * it into an index from 0-25.
     * 
     * efficiency - O(1)
     */ 

    private int charToIndex(String data){
        if (data.equals("")){
            System.out.println("ERROR: chartoindex has empty string!!");
            return 0;
        } else {
            char character = Character.toLowerCase(data.charAt(0));
            return character - 'a';
        }
    }

    /**
     * @param data - prefix to start with(gets cut down)
     * @param curr - current node
     * @param prefix - prefix that gets added up
     * @return a string of the remaining words
     * 
     * This method I created for fun takes in a prefix, then returns 
     * all the words in the tree that contain that prefix(input "wa", return "water", "watch")
     * it works by recursing down the the correct node according to "data,"
     * then it simpley toStrings that node. 
     * 
     * efficiency - O(n)
     * n is number of words in tree
     */ 

    public String getAutoComplete(String data){
        return getAutoComplete(data, root, "");
    }

    private String getAutoComplete(String data, Node curr, String prefix){
        if (data.equals(curr.data) || curr.data.indexOf(data) >= 0){
            return toString(prefix , curr);
        } else if (data.length() <= curr.data.length()){
            return "";
        } else if (curr.arr[charToIndex(data.substring(curr.data.length()))] == null){
            return "";
        } else {
            return getAutoComplete(data.substring(curr.data.length()), curr.arr[charToIndex(data.substring(curr.data.length()))], prefix + curr.data);
        }
    }
    
    class Node{
        String data;
        Node[] arr;
        boolean flag;

        /**
        * @param data - the string to be stored in that node
        * 
        * This constructer creates a node with the input data,
        * creates an array of 26 nodes (for each letter of the alphabet),
        * and sets its flag to false by default
        * 
        */ 

        public Node(String data){
            this.data = data;
            arr = new Node[26];
            flag = false;
        }
        
        /**
        * @param none
        * @return int value of the number of children
        * 
        * This method gives the number of children (nodes in its array)
        * If a spot in the array is not null, count++,
        * return count
        * 
        * efficiency - O(1)
        */ 

        public int status(){
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                if (arr[i] != null){
                    count++;
                }
            }
            return count;
        }    

        /**
        * @param none
        * @return String 
        * 
        * This method simply prints the data of the node,
        * and the data of all the children it has
        * 
        * effeciency - O(26)
        */ 

        public String toString(){
            String toReturn = "";
            toReturn += data + " -> ";
            for (int i = 0; i < arr.length; i++){
                if (arr[i] != null){
                    toReturn += arr[i].data + ", ";
                }
            }
            return toReturn;
        }

        /**
        * @param char c - where to look in array
        * @return node 
        * 
        * This method was used for testing and returns the node from 
        * its parent's array. 
        */ 
        
        public Node getNode(char c){
            Node temp = arr[c - 'a'];
            return temp;
        }
    }
}
