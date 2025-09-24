/** 제공데이터 -------- */
const todos = [
    { id: 1, text: "자바스크립트 입문", done: false },
    { id: 2, text: "함수 배우기", done: true },
    { id: 3, text: "객체와 배열 배우기", done: true },
    { id: 4, text: "배열 내장함수 배우기", done: false },
];
const consoleComm = (text, type) => {
    if(type === 'start') console.log(`${'━'.repeat(5)}[ ${text} ]${'━'.repeat(5)}`);
    if(type === 'end') console.log(`${'━'.repeat(5 + text.length)}\n\n\n`)
}

/** 문제1. ForEach() = text한줄씩 ------------ */
// 모든 할 일(text)을 한 줄씩 출력하세요.
const func01 = (todos) => {
    const title = '문제1. ForEach() = text한줄씩';

    main = () => {
        todos?.forEach((item) => {
            console.log(`할일 : ${item.text}`);
        })
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func01(todos);

/** 문제2. map() =  번호. 할 일 배열 ------------ */
// 각 할 일을 "번호. 할 일" 형식의 문자열 배열로 변환하세요.
const func02 = (todos) => {
    const title = '문제2. map() =  번호. 할 일 배열';

    main = () => {
    let mapArr = todos?.map(item => `${item.id}. ${item.text}`);
    // console.log(`[ ${mapArr.toString()} ]`);
    console.log(`[ ${mapArr?.join(', ')} ]`);
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func02(todos);


/** 문제3. filter() = 완료된 할일 추출 ------------ */
// 완료된(done: true) 할 일만 새로운 배열로 추출하세요.
const func03 = (todos) => {
    const title = '문제3. filter() = 완료된 할일 추출';

    main = () => {
        let filterArr = todos?.filter(item => item.done === true);
        console.log(filterArr);
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func03(todos);


/** 문제4. find() = 아이디 3 할일 ------------ */
// 아이디(id)가 3인 할 일을 찾아서 출력하세요.
const func04 = (todos) => {
    const title = '문제4. find() = 아이디 3 할일';

    main = () => {
        let findItem = todos?.find(item => item.id === 3);
        console.log(`id: ${findItem.id} | 할일: ${findItem.text}`);
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func04(todos);


/** 문제5. some() = 완료되지 않은 항목 1개이상? ------------ */
// 할 일 목록에 완료되지 않은(done: false) 항목이 하나라도 있는지 확인하세요.
const func05 = (todos) => {
    const title = '문제5. some() = 완료되지 않은 항목 1개이상?';

    main = () => {
        let doneCheck = todos?.some(item => item.done === false);
        console.log(`${doneCheck ? '할일있음' : '할일끝남'}`);
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func05(todos);


/** 문제6. every() = 모든 할 일이 완료? ------------ */
// 모든 할 일이 완료(done: true)되었는지 확인하세요.
const func06 = (todos) => {
    const title = '문제6. every() = 모든 할 일이 완료?';

    main = () => {
        let doneCheck = todos?.every(item => item.done === true);
        console.log(`${doneCheck ? '할일완료' : '할일남음'}`);
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func06(todos);

/** 문제7. reduce() = 완료된 할일 갯수 ------------ */
// 완료된(done: true) 할 일이 몇 개인지 개수를 구하세요.
const func07 = (todos) => {
    const title = '문제7. reduce() = 완료된 할일 갯수';

    main = () => {
        let cnt = todos?.reduce((acc, cur ,idx) => {
            return cur.done ? acc += 1 : acc;
        }, 0);
        console.log(cnt);
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func07(todos);


/** 문제8. sort() = 아이디기준 내림차순 ------------ */
// 아이디(id) 기준으로 내림차순 정렬한 새 배열을 만드세요.
const func08 = (todos) => {
    const title = '문제8. sort() = 아이디기준 내림차순';

    main = () => {
        let newTodos = [...todos].sort((a,b) => b.id - a.id);
        console.log(newTodos);
        // console.log(todos);
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func08(todos);


/** 문제9. findIndex() = 배열 내장함수 배우기의 인덱스 ------------ */
// 할 일 목록에서 "배열 내장함수 배우기"의 인덱스를 구하세요.
const func09 = (todos) => {
    const title = '문제9. findIndex() = 아이디기준 내림차순';

    main = () => {
        let itemIdx = todos?.findIndex(item => item.text === '배열 내장함수 배우기');
        console.log(`인덱스 : ${itemIdx}`);
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func09(todos);

/** 문제10. 종합 응용 ------------ */
// done이 false인 항목들만 모아서, 그 text 값들만 새로운 배열로 만들어 출력하세요. 
const func10 = (todos) => {
    const title = '문제10. done=false, text값만 새로운 배열';

    main = () => {
        let newArr = todos?.filter(item => item.done === false).map(item => item.text);
        console.log(newArr);
    }

    display = () => {
        consoleComm(title, 'start');
        main();
        consoleComm(title, 'end');
    }

    display();
}
func10(todos);