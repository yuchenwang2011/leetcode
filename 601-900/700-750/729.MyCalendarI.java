729. My Calendar I
Medium

Implement a MyCalendar class to store your events. 
A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end). 
Formally, this represents a booking on the half open interval [start, end), 
the range of real numbers x such that start <= x < end.
A double booking happens when two events have some non-empty intersection 
(ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully 
without causing a double booking. Otherwise, return false and do not add the event to the calendar.
Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
 
Note:
The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 
Accepted 39,670 Submissions 81,001
Answer:
//两种方法都要掌握                                                               
class MyCalendar {
    private List<int[]> calendar;
    public MyCalendar() {
        calendar = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
        if(start > end) return false;
        for(int[] book : calendar){
            if(Math.max(start, book[0]) < Math.min(end, book[1])) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

class MyCalendar {
    TreeSet<int[]> calendar;
    public MyCalendar() {
        calendar = new TreeSet<>((a, b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        if(start > end) return false;
        int[] book = new int[]{start, end};
        
        int[] floor = calendar.floor(book);
        if(floor != null && Math.max(floor[0], book[0]) < Math.min(floor[1], book[1])) return false;
        int[] ceiling = calendar.ceiling(book);
        if(ceiling != null && Math.max(ceiling[0], book[0]) < Math.min(ceiling[1], book[1])) return false;
        calendar.add(book);
        return true;
    }
}
