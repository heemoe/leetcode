String.prototype.trim = function () {
    let result = "";

   for (let i = 0; i < this.length; i++) {
        if (this[i] !== " ") {
            result += this[i];
        }
    }   

    return result;


}

const str = "  123 456  "; // "123456"
console.log(str.trim());
