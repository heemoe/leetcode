
/* 
    password validation function without regex, no consecutive characters more than 3 times, letter consists of one lowercase, one uppercase, one number, length 8-20
*/

function validatePassword(password) {
  let result = true;
  let count = 0;

  if (password.length < 8 || password.length > 20) {
      result = false;
  }

  for (let i = 0; i < password.length; i++) {
      if (password[i] === password[i + 1]) {
          count++;
      } else {
          count = 0;
      }

      if (count > 2) {
          result = false;
      }
  }

  // regex test result contains  one number, one uppercase, one lowercase
  const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,20}$/;
  if (!regex.test(password)) {
      result = false;
  }
 

  return result;
}
