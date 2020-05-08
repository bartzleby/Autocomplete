/******************************************************************************
 *  Name:     Danny Bartz
 *  NetID:    
 *  Precept:  
 *
 *  Partner Name:       
 *  Partner NetID:      
 *  Partner Precept:    
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
fistIndexOf() method first runs a binary search on the input array to find any
index of array that matches key.  It then calls a method that decrements the 
index while the key at the decremented index is equal to key at current i.

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor:
The constructor will not depend on the number of matching terms, m.  
It calls the Java utility Arrays.sort() which will sort terms in lexigraphic order by string query.
To do this Arrays.sort() uses the mergesort algorithm for such a type.  Therefore
the order of growth for number of compares = O(n*lg(n)).

allMatches(): we consider:
const.		Term(prefix, 0)
lgN + M		BSD.firstIndexOf(), #terms by prefixOrder
lgN	+ M		BSD.lastIndexOf(), #terms by prefixOrder
M			declare Term Array [#matches]
M			loop through #matches
M lgM		Arrays.sort matches by reverse weight order
--------
~( lgN + M lgM ) compares
		
numberOfMatches():
BSD.firstIndexOf(), #terms by prefixOrder
BSD.lastIndexOf(), #terms by prefixOrder
--------
~( lgN + M ) compares



/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/

used web searches to remind me of various useful Java functions, 
e.g. substring(), Double.compare().

Bug in the byPrefixOrder comparator if r > length of query

used a modified version of Sedgewick's BinarySearch class.


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/

Only minor problem in passing r to byPrefixOrder.compare(), 
resolved quickly.


/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/







/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/

  
