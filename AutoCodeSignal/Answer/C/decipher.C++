fn decipher(cipher: String) -> String {
    let mut it = cipher.chars();
    let mut res = String::new();
    loop {
        let mut cur = match it.next() {
            None => return res,
            Some(x) => x.to_digit(10).unwrap() as u8,
        };
        while cur < b'0' {
            cur = cur * 10 + it.next().unwrap().to_digit(10).unwrap() as u8;
        }
        res.push(cur as char);
    }
    res
}
