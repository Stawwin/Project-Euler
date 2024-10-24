compute(1, 1).
compute(N, Result) :-
    N > 1,
    N mod 2 =:= 0,
    N1 is N - 1,
    p(N, P),
    compute(N1, C),
    Result is (C + P) mod 987654321.

compute(N, Result) :-
    N > 1,
    N mod 2 == 0,
    M is (N - 1) // 2,
    compute(M, C),
    Result is (1 + 2 * M * (M + 1) + 4 * M - 4 * C) mod 987654321.

p(1, 1).
p(2, 2).
p(N, Result) :-
    N > 2,
    V is N // 2,
    p(V, PV),
    Result is 2 * V + 2 - 2 * PV.

main :-
    N is 1000,
    compute(N, Result),
    write(Result).
