function squareDigitsSequence(a0::Int32)
    a = [a0]
    k = 1
    j = sum(digits(a0).^2)
    while any(~(j in a))
        append!(a, j)
        k += 1
        j = sum(digits(a[k]).^2)
    end
    k+1
end