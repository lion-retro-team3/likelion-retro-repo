//실전응용
// 도서관 시스템을 만들어보세요
class Book {
  constructor(title, author, pubYear, isAvailable) {
    this._title = title;
    this._author = author;
    this._pubYear = pubYear;
    this._isAvailable = isAvailable;
  }
  get title() {
    return this._title;
  }
  get author() {
    return this._author;
  }
  get pubYear() {
    return this._pubYear;
  }
  get isAvailable() {
    return this._isAvailable;
  }
}

class Library {
  constructor(books) {
    this._books = books;
  }

  get books() {
    return this._books;
  }

  // 2. 책 제목으로 검색하는 함수를 만드세요
  findBookByTitle = (title) => {
    const books = this.books;
    let result = books.find((b) => b.title === title);
    if (result === undefined) result = `${title} 이 도서관에 없습니다.`;
    return result;
  };

  // 3. 대여 가능한 책들의 제목만 출력하는 함수를 만드세요
  getAvailableBooksTitle = () => {
    const books = this.books;
    const titles = new Array();
    books.forEach((book) => {
      if (book.isAvailable == true) titles.push(book.title);
    });
    const titlesFilter = books
      .filter((book) => book.isAvailable == true)
      .map((book) => book.title);
    return titlesFilter;
  };

  // 4. 새 책을 추가하는 함수를 만드세요
  addNewBook = (book) => {
    const books = this.books;
    const length = books.length;
    let result = "";
    this.books.push(book);
    if (length + 1 === books.length) {
      result = `${JSON.stringify(book)} 추가 성공`;
      return result;
    } else {
      result = `${JSON.stringify(book)}  추가 실패`;
      return result;
    }
  };
}

// 1. 책 객체들이 담긴 배열을 만드세요 (제목, 저자, 출간년도, 대여 상태)
const books = [
  new Book("어린 왕자", "생텍쥐페리", 1943, true),
  new Book("데미안", "헤르만 헤세", 1919, false),
  new Book("죄와 벌", "도스토옙스키", 1866, true),
  new Book("동물농장", "조지 오웰", 1945, true),
  new Book("삼국지", "나관중", 1522, false),
  new Book("홍길동전", "허균", 1612, true),
  new Book("태백산맥", "조정래", 1983, false),
  new Book("토지", "박경리", 1969, true),
  new Book("채식주의자", "한강", 2007, false),
];

const library = new Library(books);
console.log("이용가능한 책 제목 찾기===========================");
console.log(library.getAvailableBooksTitle());

console.log("도서관이 소유한 책 찾기============================");
console.log(library.findBookByTitle("죄와 벌"));
console.log(library.findBookByTitle("죄와 벌2"));

console.log("새로운 책 추가===============================");
console.log("추가 전 => " + library.getAvailableBooksTitle());
let newBook = new Book("소년이 온다", "한강", 2014, true);
console.log(library.addNewBook(newBook));
newBook = new Book("오이디푸스 왕", "소포클레스", -429, true);
console.log(library.addNewBook(newBook));
newBook = new Book("신곡", "단테 알리기에리", 1320, false);
console.log(library.addNewBook(newBook));

console.log("추가 후 => " + library.getAvailableBooksTitle());
