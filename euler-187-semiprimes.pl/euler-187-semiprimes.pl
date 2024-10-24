% Predicate to check if a number is prime
isPrime(N) :-
    % 1 is not a prime number
    N > 1,
    % Find the floor of the square root of the number
    Floor is floor(sqrt(N)),
    % Check if the number is divisible by any number between 2 and the floor of the square root of the number
    + (between(2, Floor, I), N mod I =:= 0).

% Predicate to check if a number is a semiprime
isSemiprime(N) :-
    % Iterate over all numbers between 2 and the input
    between(2, N, I),
    % Check if I is a prime number
    isPrime(I),
    % Set J to be N divided by I
    J is N // I,
    % Check if J is a prime number
    isPrime(J),
    % Check if I * J is equal to the input
    I * J =:= N.

% Predicate to count the number of semiprimes less than the input
countSemiprimes(Input, Count) :-
    % Find all semiprimes between 2 and the input
    findall(X, (between(2, Input, X), isSemiprime(X)), List),
    % Remove duplicates
    list_to_set(List, Set),
    % Find the length of the set
    length(Set, Count).

% Entry point
main(Input) :-
    % Find the number of semiprimes which are less than the input
    countSemiprimes(Input, Count),
    % Print the output
    writeln(Count).
