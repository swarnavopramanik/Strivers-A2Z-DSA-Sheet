https://www.codingninjas.com/studio/problems/maximum-meetings_1062658?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/*
    Time Complexity: O(N * log(N)).
    Space Complexity: O(N).

    Where 'N' is the number of meetings.
*/
import java.util.Arrays;
import java.util.Comparator;

class Meeting {
    int meetingID;
    int startTime;
    int endTime;

    public Meeting(int meetingID, int startTime, int endTime) {
        this.meetingID = meetingID;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class Solution {
    public static int maximumMeetings(int[] start, int[] end) {
        int n = start.length;

        // Creating an array of Meeting objects of size N.
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(i + 1, start[i], end[i]);
        }

// Sorting the meetings array in increasing order of end time using customized comparator.
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting a, Meeting b) {
                if (a.endTime == b.endTime) {
                    return a.meetingID - b.meetingID;
                } else {
                    return a.endTime - b.endTime;
                }
            }
        });

        // Taking the first meeting of sorted array as our first meeting.
        int ans = 1;
        int currentTime = meetings[0].endTime;

        for (int i = 1; i < n; i++) {
            // If startTime of the current meeting is greater than our currentTime,
            // then we will perform this meeting and update currentTime with endTime of the meeting.
            if (meetings[i].startTime > currentTime) {
                ans++;
                currentTime = meetings[i].endTime;
            }
        }

        return ans;
    }
}
