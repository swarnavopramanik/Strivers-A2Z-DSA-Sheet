https://www.codingninjas.com/studio/problems/sjf_1172165?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.Arrays;

import java.util.Comparator;

import java.util.PriorityQueue;

import java.util.Queue;

 

public class Solution {

 

static class Job {

int arrivalTime;

int burstTime;

 

Job(int arrivalTime, int burstTime) {

this.arrivalTime=arrivalTime;

this.burstTime=burstTime;

}

}

 

static class JobComparator implements Comparator<Job> {

public int compare(Job a, Job b){

if(a.arrivalTime==b.arrivalTime) {

return a.burstTime-b.burstTime;

}

return a.arrivalTime-b.arrivalTime;

}

}

 

public static float sjf(int n, int []arrivalTime, int []burstTime)

{

 

Job[] jobs = new Job[n];

for (int i = 0; i < n; i++) {

jobs[i] = new Job(arrivalTime[i], burstTime[i]);

}

 

Arrays.sort(jobs, new JobComparator());

 

Queue<Job> pq = new PriorityQueue<>((a, b) -> a.burstTime - b.burstTime);

pq.offer(jobs[0]);

// {

// {arrivalTime=4, burstTime=21},

// {arrivalTime=10, burstTime=29},

// {arrivalTime=11, burstTime=7},

// {arrivalTime=12, burstTime=26},

// {arrivalTime=22, burstTime=3},

// {arrivalTime=24, burstTime=6},

// {arrivalTime=25, burstTime=14},

// {arrivalTime=29, burstTime=11},

// {arrivalTime=29, burstTime=28}

// }

 

int time = jobs[0].arrivalTime;

int waitTime = 0;

int i = 1;

 

while (!pq.isEmpty()) {

Job curr = pq.poll();

time = Math.max(time, curr.arrivalTime);

waitTime += time - curr.arrivalTime;

time += curr.burstTime;

while (i < n && jobs[i].arrivalTime <= time) {

pq.offer(jobs[i]);

i++;

}

if (pq.isEmpty() && i < n) {

pq.offer(jobs[i]);

}

}

 

return (float) waitTime / n;

 

}

}
