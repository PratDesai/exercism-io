module Leap

let leapYear (year: int): bool = 
    year % 4 = 0 && not (year % 100 = 0 && year % 400 <> 0)

let leapYearMentorSolution1 =
    function
    | year when year % 4 = 0 && year % 100 <> 0 -> true
    | year when year % 400 = 0 -> true
    | _ -> false

let leapYearMentorSolution2 (year: int): bool =
    match (year % 4, year % 100, year % 400) with
    | (0, 0, 0) -> true
    | (0, 0, _) -> false
    | (0, _, _) -> true
    | (_, _, _) -> false