function getTravelTime(distance) {
  return function(speed) {
    return distance / speed;
  };
}
 
const travelTimeBosNyc = getTravelTime(400);
const travelTimeMiamiAtlanta = getTravelTime(600);
console.log(travelTimeBosNyc(100));
