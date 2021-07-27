package main;

enum RomanNumeral {
    C(100),
    XC(90),
    LXXX(80),
    LXX(70),
    LX(60),
    L(50),
    XL(40),
    XXX(30),
    XX(20),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    int value;

    RomanNumeral(int value) {
        this.value = value;
    }

}