# Electricity-Distribution-Company
Imagine you established a new electricity distribution company. For each 10 km, you should use one electricity pole and you should use the minimum number of poles that will provide electricity to cities you are responsible for. For this reason, you need to create a kind of map. 
The input.txt file given to you contains the name and coordinates (x and y, respectively) of the city. Example input.txt is as follows:

A,2,2

B,3,5

C,5,5

D,-1,2

E,3,0

You should read input.txt file, and construct your graph based on this information. For example, the first line means that City A is on coordinate x=2 and y=2, or the second line means that City B is on coordinate x=3, y=5.  

You can assume that there is always a path between any two cities and you should use Euclidian distance to calculate length of this path. For example, there is a path from cities D to E and E to D. Their lengths are equal to:  

                                                                          sqrt((−1−0)^2 +(2−3)^2))= sqrt(2)

Your goal is to find paths to provide electricity to all cities and require the use of the least number of poles. While printing, you should print the path in ascending order of their length. Also, your path starts with city which comes from alphabetically first.
