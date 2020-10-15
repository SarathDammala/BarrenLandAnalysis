# BarrenLandAnalysis

<h2>Acceptance Criteria:</h2>

You have a farm of 400m by 600m where coordinates of the field are from (0, 0) to (399, 599). A portion of the farm is barren, and all the barren land is in the form of rectangles. Due to these rectangles of barren land, the remaining area of fertile land is in no particular shape. An area of fertile land is defined as the largest area of land that is not covered by any of the rectangles of barren land. 
Read input from STDIN. Print output to STDOUT 

<h2>Input: </h2>
You are given a set of rectangles that contain the barren land. These rectangles are defined in a string, which consists of four integers separated by single spaces, with no additional spaces in the string. The first two integers are the coordinates of the bottom left corner in the given rectangle, and the last two integers are the coordinates of the top right corner. 

<h2> Output </h2>
Output all the fertile land area in square meters, sorted from smallest area to greatest, separated by a space. 

<h2> Sample walkthru with a smaller farm: </h2>
Below is the screenshot of a sample 10 * 10 farm, the algorithm needs to calculate all the continous fertile areas (marked in green).
BarrenAreas: "0 2 4 7", "5 0 9 7", "4 7 7 9"
Areas Calculated in order: "4 8 10"
<div>
  <a href="#"><img src="/images/sample_farm.PNG" height="150" width="150" ></a>
</div>
</br>

<h2> Console log (for 400*600 farm) : </h2>
<div>
  <a href="#"><img src="/images/console_screenprint.PNG" height="150" width="150" ></a>
</div>
P.S: The dimensions are hard coded to 400 * 600 in the code.
