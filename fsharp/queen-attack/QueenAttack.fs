module QueenAttack

let create =
    function
    | (x, _) when x < 0 || x > 7 -> false
    | (_, y) when y < 0 || y > 7 -> false
    | _ -> true

let canAttack (q1x, q1y) (q2x, q2y) =
    match q1x - q2x, q1y - q2y with
    | 0, _ -> true
    | _, 0 -> true
    | dx, dy when abs (dx) = abs (dy) -> true
    | _ -> false
