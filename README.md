# Account-Validation

Account number  modulo 11 validation

#### Assumptions

- The account must follow the format : xxxx.yy.zzzzC (where C is control digit).

- Space, hyphen  and other separators will be rejected with proper error messages.

- As we run the program, input needs to be passed as main argument.

- Program runs in controlled fashion and can be terminated while asked upon.

#### Run

- change directory to 'src'

- compile : ```javac no/bank/account/exception/*.java no/bank/account/util/*.java no/bank/account/*.java AccountValidationRunner.java```

- execute : ```java AccountValidationRunner```
