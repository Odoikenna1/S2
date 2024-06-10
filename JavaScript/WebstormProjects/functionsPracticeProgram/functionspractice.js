function calculateArea(width, height){
   let area= height * width;
   return area;
}
function convertToFahrenheit(temperatureInCelsius)
{
   //convert celsius to fahrenheit
   let F = temperatureInCelsius * 9 / 5 + 32;
   return F;
}
function isEven(number){
   if(number % 2 === 0)
      return true;
   else{
      return false;
   }
}
function isLeapYear(year)
{
   if (year % 4 === 0 ) return true;
   if (year % 100 === 0) return true;
   return year % 400 === 0;
}
function countVowels(strings)
{
   let substrings = ['a','e','i','o','u']
   let vowelCount = 0;
   for (let count = 0; count < substrings.length; count++){
      for (let chars = 0; chars < strings.length; chars++)
      {
         if (strings.charAt(chars) === substrings[count])
         {
            vowelCount+=1;
         }
      }
   }
   return vowelCount;
}
module.exports = {calculateArea,convertToFahrenheit, isEven, isLeapYear, countVowels};
