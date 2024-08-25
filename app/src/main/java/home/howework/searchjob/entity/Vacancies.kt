package home.howework.searchjob.entity

interface Vacancies {

   var id               : String
   var lookingNumber    : Int
   var title            : String
   var address          : Address
   var company          : String
   var experience       : Experience
   var publishedDate    : String
   var isFavorite       : Boolean
   var salary           : Salary
   var schedules        : ArrayList<String>
   var appliedNumber    : Int
   var description      : String
   var responsibilities : String
   var questions        : ArrayList<String>

}