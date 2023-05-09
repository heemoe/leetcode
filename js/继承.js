// 原型链继承
function demo1() {
  function Parent() {
    this.names = ["a", "b"];
  }

  function Child() {}

  Child.prototype = new Parent();
  var sub = new Child(); // 不能向parent传参
  sub.names.push("c");
  console.log(sub.names); // a,b,c

  var sub2 = new Child();
  console.log(sub2.names); // a,b,c
  // 这种方式会共享父类的引用属性，如果子类修改了引用属性，会影响到其他子类
}

// 构造函数继承
function demo2() {
  function Parent(name) {
    this.name = name;
    this.names = ["a", "b"];
  }

  function Child(name) {
    Parent.call(this, name);
  }

  var child1 = new Child("myName");
  child1.names.push("c");
  console.log(child1.names); // a,b,c
  console.log(child1.name); // myName 传参成功
  var child2 = new Child();
  console.log(child2.names); // a,b
  // 这种方式只能继承父类的实例属性和方法，不能继承原型属性和方法
  // 无法实现复用，每个子类都有父类实例函数的副本，影响性能
}

// 组合继承

function demo3() {
  function Parent(name) {
    this.name = name;
    this.names = ["a", "b"];
  }

  Parent.prototype.getName = function () {
    return this.name;
  };

  function Child(name, age) {
    Parent.call(this, name);
    this.age = age;
  }

  Child.prototype = new Parent(); // 继承父类的原型方法
  Child.prototype.constructor = Child; // 修复构造函数指向

  var child1 = new Child("myName", 18);
  child1.names.push("c");
  console.log(child1.names, child1.getName(), child1.age); // a,b,c, myName, 18

  var child2 = new Child("myName2", 19);
  console.log(child2.names, child2.getName(), child2.age); // a,b, myName2, 19

  // 这种方式会调用两次父类构造函数，生成两份实例，浪费内存
  // Child.prototype = new Parent() 和 var child1 = new Child("myName", 18)。
}

// 原型式继承
function demo4() {
  function createObj(o) {
    // 本质上是对传入的对象进行浅复制, ES5 Object.create()方法
    function F() {}
    F.prototype = o;
    return new F();
  }

  var person = {
    name: "kevin",
    friends: ["daisy", "kelly"],
  };

  var person1 = createObj(person);
  var person2 = createObj(person);

  person1.name = "person1";
  person1.friends.push("jack");
  console.log(person2.name); // kevin
  console.log(person1.friends === person2.friends); // true
  console.log(person2.friends); // ["daisy", "kelly", "jack"]
  // 引用类型的属性值始终都会共享相应的值，这点和类式继承一样
}

// 寄生式继承
function demo5() {
  function Parent(name) {
    this.name = name;
    this.names = ["a", "b", "c"];
  }

  Parent.prototype.getName = function () {
    console.log(this.name);
  };

  function Child(name, age) {
    Parent.call(this, name);
    this.age = age;
  }

  // Child.prototype = new Parent();
  // Child.prototype.constructor = Child;

  var F = function () {}; // 创建一个没有实例方法的类式继承
  F.prototype = Parent.prototype;
  Child.prototype = new F(); // 将实例作为子类的原型

  var child1 = new Child("kevin", "18");
  console.log(child1); // Child { name: 'kevin', names: [ 'a', 'b', 'c' ], age: '18' }
}
// 封装寄生式继承的函数
function demo6() {
  function object(o) {
    // 本质上是对传入的对象进行浅复制, ES5 Object.create()方法
    var F = function () {};
    F.prototype = o;
    return new F();
  }

  function prototype(child, parent) {
    var prototype = object(parent.prototype); // 创建对象
    prototype.constructor = child;
    child.prototype = prototype;
  }

  function Parent(name) {
    this.name = name;
    this.names = ["a", "b", "c"];
  }
  Parent.prototype.getName = function () {
    console.log(this.name);
  };
  function Child(name, age) {
    Parent.call(this, name); // 继承父类的实例属性
    this.age = age;
  }

  function Child2(name, age, gender) {
    Child.call(this, name, age); // 继承父类的实例属性
    this.gender = gender;
  }

  prototype(Child, Parent);
  prototype(Child2, Child);

  var child1 = new Child("kevin", "18");
  console.log(child1); // Child { name: 'kevin', names: [ 'a', 'b', 'c' ], age: '18' }
  // 这种方式相比于原型式继承，可以传参，相比于寄生式继承，可以复用父类的原型方法

  var child2 = new Child2("jack", 22, "male");
  console.log(child2);
}

demo6();
