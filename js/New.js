function myNew(Func, ...args) {
  const obj = {};
  obj.__proto__ = Func.prototype;
  Func.apply(obj, args);
  return obj;
}

const Person = function (name, age) {
  this.name = name;
  this.age = age;
  console.log("modify this")

  return {
    name: this.name + "123",
    age: this.age,
  }
};

const person = myNew(Person, "Tom", 18);

console.log(person);

/**
 * 创建一个空对象，空对象__proto__指向构造函数原型，将构造函数的this指向这个空对象，执行构造函数，返回这个空对象
 */
