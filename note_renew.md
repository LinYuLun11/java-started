# Java 物件導向語言 (OOP)

> 幾乎所有程式內容都放在 class 中

---

## What is Class？

- **class** → 藍圖
- 定義一個物件有哪些資料與功能

```java
public class Player {   // Player 物件
    String name;        // attribute 屬性
    int hp;
    int level;
}
```

### 建立物件 → new 一個物件

```java
Player p1 = new Player();
p1.name = "Allen";
p1.hp = 100;
p1.level = 1;
```

---

## Java 編譯 (Compile)

```
.java  →  javac 編譯  →  .class  →  JVM 執行
```

---

## 1. 資料型態

### 數字範圍比較

```
double > float > long > int > short > byte
```

### 小範圍 → 大範圍（自動轉型）

```java
byte a1 = 3;
short a2 = a1;
int a3 = a2;

long a4 = 12345;    // 指派時 12345 是 int，但會自動轉型宣告成 long
float a5 = a4;
```

### 大範圍 → 小範圍（需強制轉換）

```java
int b1 = 3;
byte b2 = b1;       // error!

double b3 = 3.5;
float b4 = b3;      // error!

float b5 = 10.5;    // 預設 10.5 為 double → error!
```

### 強制轉換：有可能失真

```java
int c1 = 3;
byte c2 = (byte) c1;

int c3 = 128;
byte c4 = (byte) c3;
// 由於 128 超過 byte(-127~127) 因此會失真
// 原理是將大範圍轉成二進位，去掉高位元，直到成為小範圍二進位長度

double c5 = 3.1415926536;
float c6 = (float) c5;  // 失真!
```

---

## 2. 文字轉數字：parse

```java
parseInt()
parseLong()
parseFloat()
parseDouble()
```

---

## 3. 數字轉字串：valueOf

```java
String.valueOf(123);
String.valueOf(5555555L);
String.valueOf(3.14F);
String.valueOf(3.1415926);
```

---

## 4. 輸入 Scanner

```java
import java.util.Scanner;

// new 一個新物件，指向 Scanner 記憶體位置
Scanner input_obj = new Scanner(System.in);

String word      = input_obj.next();        // 一個單字
String sentence  = input_obj.nextLine();    // 一整行文字
int age          = input_obj.nextInt();     // 整數
double price     = input_obj.nextDouble();  // 小數
boolean flag     = input_obj.nextBoolean(); // true/false
```

### ⚠️ Problem：nextInt() 與 nextLine() 的陷阱

```java
int age = input_obj.nextInt();
String name = input_obj.nextLine(); // 這邊會被跳過
```

> `nextInt()` 只讀取數字，Enter 不會被吃掉，所以後面的 `nextLine()` 會直接讀到空白換行

### ✅ Solution

```java
int age = input_obj.nextInt();
input_obj.nextLine();   // 加入這行，吃掉殘留的換行

String name = input_obj.nextLine();

input_obj.close();      // Scanner 關閉，也就是關閉輸入資源
```

---

## 5. Array

### 初始化

宣告 array 的資料型態，並給予長度，利用 `new` 語法。
初始化時若沒有給予值，自動填入 `0`。

```java
int[] x = new int[4];       // 無給予值
double[] y = new double[5];

int[] z = new int[]{1,2,3}; // 給予值時，不要宣告長度
```

### 取得 array 長度

```java
length()
```

---

## Static 關鍵字

用來修飾 class、method、member。

**意思：** 程式載入記憶體時，跟著程式一起在記憶體中佔有空間，而不是主程式開始執行後才跟記憶體要空間。

### 最常見用途

1. 全域共用資料
2. 工具方法

### Static Method

```java
static int add()    // 需要回傳值
static void print() // 無須回傳值，但也可加入 return 作為中斷程式的一種方式
```

---

## Package（套件）

若沒有 package，當專案很大時，名字會衝突。

**package 的本質：** class 的資料夾 / 命名空間

### 規則

- package 必須對應資料夾
- 命名習慣：全部小寫

```
package game.player;
// 實際資料夾：game/player/
```

### 完整架構

```
src/
└─ game/
     └─ player/
         └─ Player.java
```

### Import

當 class 在不同 package，需要 `import` → 把其他 package 的 class 引入

---

## Access Modifier(存取修飾詞)

用途：控制誰能使用你的資料與方式

|            | 同 class | 同 package | 子類別 | 任何地方 |
|------------|:--------:|:----------:|:------:|:--------:|
| `private`  | ✅       | ❌         | ❌     | ❌       |
| `default`  | ✅       | ✅         | ❌     | ❌       |
| `protected`| ✅       | ✅         | ✅     | ❌       |
| `public`   | ✅       | ✅         | ✅     | ✅       |

> ⭐ **超重要規則：** 一個檔案中只能有一個 `public class`，且名字必須與檔名相同。

---

## Class 分類

### 1. 普通 class（最常見）

```java
class Player {}
```

### 2. public class（可跨 package 使用）

```java
public class Player {}
```

### 3. abstract class（抽象類別）

- 不能直接 `new`
- 作為父類模板

```java
abstract class Animal {
    abstract void sound();
}
```

### 4. final class（不能被繼承）

```java
final class GameManager {}
```

### 5. static nested class（class 中的 class）

```java
class Game {
    static class Player {}
}
```

### 6. inner class（依附於物件）

```java
class Game {
    class Player {}
}
```

### 7. interface（介面）

```java
// 不是 class，但很重要
interface Flyable {}
```

---

## 物件實體

- **class** → 角色模板
- **object / instance** → 真正生成出來的角色

```java
class Player {
    String name;
    int hp;
}

Player p1 = new Player(); // 成功建立了一個 Player
```

### `new` 做了什麼？

1. 建立記憶體空間
2. 初始化屬性
   - `String name;` → `name = null`
   - `int hp;` → `hp = 0`
3. 呼叫 Constructor
4. 回傳物件位置

---

## Constructor（建構子）

建立物件時自動執行的方法。

**特徵：**
1. 名字必須要與 class 一樣
2. 沒有回傳型別

### 最基本的 Constructor

```java
class Player {
    Player() {
        System.out.println("玩家建立完成");
    }
}
```

> **真正用途：** 初始化物件

---

## this 關鍵字

```java
// ❌ 問題：左右兩邊的 name 皆為參數，不是 class 屬性
class Player {
    String name;
    Player(String name) {
        name = name;
    }
}

// ✅ 解法：使用 this
class Player {
    String name;
    Player(String name) {
        this.name = name;
    }
}
```

> `this` → 指的是這個物件本身，所以 `this.name` 代表物件自己的 `name` 屬性

---

## Constructor Overloading

沒有自己寫 Constructor → 會有 default constructor

```java
class Player {
    String name;
    int hp;

    Player() {
        name = "未知";
        hp = 100;
    }
    Player(String n) {
        name = n;
        hp = 100;
    }
    Player(String n, int h) {
        name = n;
        hp = h;
    }
}

Player p1 = new Player();
Player p2 = new Player("Allen");
Player p3 = new Player("Allen", 999);
```

---

## 物件實體的重要性

Java 幾乎所有東西都是 object，像是 `Scanner`、`String`、`ArrayList`...

### 記憶體概念

| 區域    | 儲存內容              |
|---------|-----------------------|
| `stack` | 存 reference（位址）  |
| `heap`  | 真正的物件            |

---

## Getter/Setter

當屬性是private的時候，無法直接存取，這時就需要Getter and Setter

Getter：取得資料的方式
Setter：修改資料的方式

```java
class Player {

    private String name;
    private int hp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
```

Java OOP核心之一，封裝(Encapsulation)
核心思想：資料不要直接暴露，而是透過方式進行存取

其實getter/setter不只可以存取，setter可以加上限制，getter可以進行加工

## Inheritance(繼承)

核心概念：子類別繼承父類別的能力 -> 可以直接繼承共用功能。
目的：共用的內容只要放在一處就好，避免重複的程式碼出現。

What is extends？
class dog extends Animal -> dog 繼承 Animal

繼承之後，子類別會獲得父類別的field(屬性)、method(方法)

```java
public class Father{
    public String name;
    public Father(String name){
        this.name = name;
    }

    public void print(){
        System.out.println(this.name);
    }
}

public class Child extends Father{
    public int number;
    public Child(String name,int num){
        super(name);    //super() -> 呼叫父類參數建構式
        this.number = num;
    }
}

public class inheritance {
    public static void main(String[] args){
        Child son = new Child("Bob", 15);
        son.print();
    }
}
```

## Upcasting/Downcasting

父纇與子類之間的型別關係

Upcasting -> 向上轉型
Overriding + Upcasting

```java
class Animal {

    void sound() {
        System.out.println("動物");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("汪");
    }
}

Animal a = new Dog();
a.sound();  // result: 汪
```

這就是polymorphism(多型)
同樣是Animal，可能是 new Dog() or new Cat() or new Bird()，這樣 a.sound();會有不同的結果。

Downcasting -> 向下轉型
Downcasting必須強制轉型，因為不是所有animal都是dog

```java
Animal a = new Dog();

Dog d = (Dog)a;

d.bark();
```

instanceof -> 為了解決 Downcast爆炸
```java
a instanceof Dog // a 是不是 Dog 類型
```

安全Downcast
```java
Animal a = new Dog();

if(a instanceof Dog) {

    Dog d = (Dog)a;

    d.bark();
}
```

## Abstract Class(抽象類別) and Interface(介面)

inheritance解決「共通內容」
abstract/interface解決「規則與設計」

### abstract核心思想：
概念存在，但不能直接實體化

```java
abstract class Animal{

}
Animal a = new Animal(); //❌ 錯誤，不能使用new，因為abstract class 不完整
```

完整範例：
```java
abstract class Animal {

    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void sound();
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    //why override? -> 因為Animal規定了abstract method，所以子類別一定要實作
    //若不override，Dog也必須變abstract
    @Override
    void sound() {
        System.out.println("汪");
    }
}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Bob");

        dog.sound();
    }
}
```

abstract class可以有普通method
```java
abstract class Animal {

    void eat() {
        System.out.println("吃東西");
    }

    abstract void sound();
}
```

abstract class常見用途： 共通功能+強制規則

### interface核心思想
不是「是什麼」，而是「能做什麼」，interface就像能力標籤

```java
interface Flyable {
    void fly();
}
```

### implements
class 使用 interface
```java
class Bird implements Flyable{

}
```
並非使用 extends

完整範例：
```java
interface Flyable {
    void fly(); //預設其實是public abstract，所以其實這個等於public abstract void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() { //  必須為public
        System.out.println("飛行");
    }
}

public class Main {

    public static void main(String[] args) {
        Bird b = new Bird();
        b.fly();
    }
}
```

為甚麼需要interface？
->java只能單繼承
->但interface可以多實作，例如： class Duck implements Flyable, Swimmable
->讓一個class能擁有多種能力

### Abstract vs Interface
|                | Abstract  | Interface  |
| -------------  | --------  | ---------- |
|   關係         | 是什麼     | 能做什麼       |
|   關鍵字       | extends    | implements |
| 能有普通method | ✅        | 以前❌ 現在部分✅  |
|   能有field    | ✅        | 常數 only    |
|   constructor | ✅         | ❌          |
|   多繼承       | ❌         | ✅          |
|   使用情境     | 共通基底    | 規格/能力      |
