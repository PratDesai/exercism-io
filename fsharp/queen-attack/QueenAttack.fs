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

let canAttackSecondSolution =
    function
    | (q1x, q1y) ->
        function
        | (q2x, _) when q1x = q2x -> true
        | (_, q2y) when q1y = q2y -> true
        | (q2x, q2y) when abs (q1x - q2x) = abs (q1y - q2y) -> true
        | _ -> false

let canAttackFirstSolution (q1x: int, q1y: int) (q2x: int, q2y: int) =
    match () with
    | () when q1x = q2x -> true
    | () when q1y = q2y -> true
    | () when abs (q1x - q2x) = abs (q1y - q2y) -> true
    | _ -> false
