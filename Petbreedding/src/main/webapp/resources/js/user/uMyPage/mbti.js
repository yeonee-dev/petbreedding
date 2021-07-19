const main = document.querySelector("#main");
const qna = document.querySelector("#qna");
const result = document.querySelector("#result");

const endPoint = 16;
const select = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

function calResult(){
  console.log(select);
  var result = select.indexOf(Math.max(...select)); //최고로 많이 뽑힌
  return result;
}

function setResult(){
  let point = calResult();
  const resultName = document.querySelector('.resultname');
  resultName.innerHTML = infoList[point].name;

  var resultImg = document.createElement('img');
  const imgDiv = document.querySelector('#resultImg');
  var imgURL = '/petbreedding/resources/images/image_' + point + '.png';
  console.log("imgURL : "+ imgURL);
  resultImg.src = imgURL;
  resultImg.alt = point;
  resultImg.classList.add('img-fluid');
  imgDiv.appendChild(resultImg);

  const resultDesc = document.querySelector('.resultDesc');
  resultDesc.innerHTML = infoList[point].desc;
}

function goResult(){
  qna.style.WebkitAnimation = "fadeOut 1s";
  qna.style.animation = "fadeOut 1s";
  setTimeout(() => {
    result.style.WebkitAnimation = "fadeIn 1s";
    result.style.animation = "fadeIn 1s";
    setTimeout(() => {
      qna.style.display = "none";
      result.style.display = "block"
    }, 450)})
    setResult();
}

function addAnswer(answerText, qIdx, idx){
  var a = document.querySelector('.answerBox');
  var answer = document.createElement('button');
  answer.classList.add('answerList');
  answer.classList.add('my-3');
  answer.classList.add('py-3');
  answer.classList.add('mx-auto');
  answer.classList.add('fadeIn');

  a.appendChild(answer);
  answer.innerHTML = answerText;

  answer.addEventListener("click", function(){
    var children = document.querySelectorAll('.answerList');
    for(let i = 0; i < children.length; i++){
      children[i].disabled = true;
      children[i].style.WebkitAnimation = "fadeOut 0.5s";
      children[i].style.animation = "fadeOut 0.5s";
    }
    setTimeout(() => {
      var target = qnaList[qIdx].a[idx].type;
      for(let i = 0; i < target.length; i++){
        select[target[i]] += 1;
      }

      for(let i = 0; i < children.length; i++){
        children[i].style.display = 'none';
      }
      goNext(++qIdx);
    },450)
  }, false);
}

function goNext(qIdx){
  if(qIdx === endPoint){
    goResult();
    return;
  }

  var q = document.querySelector('.qBox');
  q.innerHTML = qnaList[qIdx].q;
  for(let i in qnaList[qIdx].a){
    addAnswer(qnaList[qIdx].a[i].answer, qIdx, i);
  }
  var status = document.querySelector('.statusBar');
  status.style.width = (100/endPoint) * (qIdx+1) + '%';
}

function begin(){
  main.style.WebkitAnimation = "fadeOut 1s";
  main.style.animation = "fadeOut 1s";
  setTimeout(() => {
    qna.style.WebkitAnimation = "fadeIn 1s";
    qna.style.animation = "fadeIn 1s";
    setTimeout(() => {
      main.style.display = "none";
      qna.style.display = "block"
    }, 450)
    let qIdx = 0;
    goNext(qIdx);
  }, 450);
}




//data

/*
ISTJ,0
ISFJ,1
INFJ,2
INTJ,3
ISTP,4
ISFP,5
INFP,6
INTP,7
ESTP,8
ESFP,9
ENFP,10
ENTP,11
ESTJ, 12
ESFJ, 13
ENFJ, 14
ENTJ, 15
*/

const qnaList = [
  {
    q: '반려견과 산책할 때,', // E/I
    a: [
      { answer: 'a. 주인님이 가자는대로 가는 댕댕이' , type: [0, 1, 2, 3, 4, 5, 6, 7 ] },
      { answer: 'b. 목줄이 끊어져라 힘으로 끌고 가는 댕댕이 ', type: [8, 9, 10, 11, 12, 13, 14, 15] },
    ]
  },
  {
    q: '2. 낯선 장소에 갔을 때, ', // EN/ ES / IN / IS
    a: [
      { answer: 'a. 처음온곳이라 낯설어...나 지금 떨고 있니?', type: [0, 1, 4, 5, 8, 9, 12, 13] },
      { answer: 'b. 여기 너무 재밌어 보이는데? 고고 얼른 들어가자!!!!', type: [2, 3, 6, 7, 10, 11, 14, 15] },
    ]
  },
  {
    q: '3. 주인님이 침대에 누워있을 때,',
    a: [
      { answer: 'a. 주인 너는 놀아라, 나는 누워있을래', type: [1, 3, 2, 10, 8] }, 
      { answer: 'b. 빨리 놀아줘 !!!!', type: [9, 10, 11, 12, 13] },
    ]
  },
  {
    q: '4. 주인이 바쁠 때,',
    a: [
      { answer: 'a. 주인이 바쁘면 나도 슬퍼... 조용히 불쌍한 척 하는 댕댕이 ', type: [1, 2, 13  ] },
      { answer: 'b. 홀로 다른 곳에서 사고치는 댕댕이 ', type: [3, 7, 8, 9, 10, 11 ] },
      
    ]
  },
  {
    q: '5. 댕댕이 교육 할 때,',
    a: [
      { answer: 'a. 교육할거면 간식을 줘라 !!! ', type: [3, 7, 8, 9, 15 ] },
      { answer: 'b. 간식따위 필요 없어 !!!! 해 달라면 다 해줄게 !!', type: [5, 6, 13]},
      
    ]
  },

  {
    q: '6. 댕댕이와 스킨십할 때,',
    a: [
      { answer: 'a. 애미야 손이 짜다-_-,, 쓰다듬으면 으르렁 대는 댕댕이', type: [3, 9, 15 ] },
      { answer: 'b. 더 쓰다듬어주세요 더 ~!!! ', type: [1, 2, 5, 6, 9, 12, 13 ] },
      
    ]
  },
  {
    q: '7. 산책하다가 낯선 강아지를 만났을 때,',
    a: [
      { answer: 'a. 반갑다 친구야~~~ 금방 친해지는 댕댕이', type: [8, 9, 10, 11, 12, 13, 14, 15 ] },
      { answer: 'b. 주인님 뒤로 숨거나 센척 하며 왕왕 짖는 댕댕이', type: [0, 1, 2, 3, 4, 5, 6, 7 ] },
      
    ]
  },
  {
    q: '8. 잘못해서 혼날 때,',
    a: [
      { answer: 'a. "왕왕왕오아!!!!" 내가 뭘잘못했어 !!! 말대꾸하는 댕댕이 ', type: [0, 3, 4, 14, 15 ] },
      { answer: 'b. 곁눈질로 힐끔힐끔 주눅 든 댕댕이', type: [1, 7, 10, 13 ] },
     
    ]
  },
  {
    q: '9. 댕댕이가 배변할 때,',
    a: [
      { answer: 'a. 내가 가는 길은 모두 다 화장실, 아무데서나 쌈마이웨이 댕댕이', type: [3, 5 ] },
      { answer: 'b. 아련하게 주인을 바라보며 배변 생중계하는 댕댕이', type: [9, 10, 11 ] },
      
    ]
  },
  {
    q: '10. 댕댕이가 놀 때, ',
    a: [
      { answer: 'a. 장난감이 뭐가 필요해? 집사 립스틱이 내 장난감인데 !!! 눈에 보이는 대로 다 물고보는 댕댕이', type: [3, 5, 7, 9, 11] },
      { answer: 'b. 주인님이 제일 좋아 ~~~ 주인님 바보 댕댕이', type: [6, 13 ] },
     
    ]
  },
  {
    q: '11. 간식 줬을 때, ',
    a: [
      { answer: 'a. 3초 컷, 또 줘 !! 댕댕이', type: [5, 9, 10 ] },
      { answer: 'b. 이건 내 간식이야.... 일단 숨기고 보는 댕댕이', type: [0, 3, 4, 15] },
    ]
  },
  {
    q: '12. 집에 손님이 있을 때,',
    a: [
      { answer: 'a. 작은 소리만 들어도 극대노.. 다 조용히 해 댕댕이', type: [0, 4, 15 ] },
      { answer: 'b. 문 열고 들어오자마자 뛰어 반기는 댕댕이', type: [10, 11, 13, 14] },
    
    ]
  },
  {
    q: '13. 주인님이 다른 강아지를 더 예뻐하는 걸 봤을 때,',
    a: [
      { answer: 'a. 나도 더 예뻐해줘 ~~ 아련하게 눈물 흘리는 댕댕이', type: [0, 15, 3, 2, 7 ] },
      { answer: 'b. 왈왈왕!!!!! 나한테만 집중하라개 !!!!!! 승질내는 댕댕이', type: [10, 11, 13, 14, 15] },
    
    ]
  },
  {
    q: '14. 주인님이 인간 음식을 먹고 있을 때,',
    a: [
      { answer: 'a. 뭘 먹거나 말거나 나는 개껌만 있으면 돼~~~', type: [0, 1, 3, 5, 6, 7 ] },
      { answer: 'b. 나도 한입만...헥헥헥...(침 뚝...)', type: [10, 11, 13, 14, 15] },
    
    ]
  },
  {
    q: '15. 집에 있는데 다른 집 댕댕이가 짖는 소리가 들렸을 때,',
    a: [
      { answer: 'a. 왈왈ㄹ왈왈!!! 뉘집 댕댕이냐 !!! 똑같이 짖는 댕댕이 ', type: [0, 2, 8 ] },
      { answer: 'b. 짖거나 말거나~~ 평온하게 하던 거 하는 댕댕이', type: [9, 15] },
    
    ]
  },
  {
    q: '16. 주인님이랑 같이 여행갔을 때,',
    a: [
      { answer: 'a. 주인님이랑 같이 있는게 지상낙원 ~~~ 주인님 곁이 제일 행복해! ', type: [0,2, 8, 9, 15 ] },
      { answer: 'b. 여기가 내 세상 !!! 여기 저기 다 뛰어다니면서 놀래~~~~!!', type: [4, 14] },
    
    ]
  }
]

const infoList = [
  {
    name: 'ISTJ 책임강이 강하고 현실적인 댕댕이',
    desc: '첵임감이 강해서 사고를 잘 안치는 댕댕이에요~<br> 매사에 철저하고 보수적이라 주인님 속 썩을 일이 잘 없답니다!'
  },
  {
    name: 'ISFJ 차분한 진국 댕댕이',
    desc: '차분하고 주인님만 바라보는 헌신적인 댕댕이에요~<    br>  인내심이 강해서 주인님이 어떤 장난을 쳐도 잘 받아준답니다.<br>  또한 주인님이 슬프면 나도 슬픈 프로 감정러에요~ '
  },
  {
    name: 'INFJ 모두 다같이 즐거운게 중요한 댕댕이',
    desc: '통찰력이 뛰어난 댕댕이라 사람들에게 칭찬을 많이 받아요~<br>  혼자 잘 먹고 잘 사는 것 보다 모든 댕댕이들의 행복을 빌어요!'
  },
  {
    name: 'INTJ 독립적인 댕댕이',
    desc: '의지가 강하고 독립적인 댕댕이라 <br> 가끔 주인님이 다른 일을 하고 관심에 소홀하다해도 크게 신경쓰지 않아요~ <br> 분석력이 뛰어난 댕댕이라 항상 주인님을 분석하고 있답니다'
  },
  {
    name: 'ISTP 과묵한 댕댕이',
    desc: '이 댕댕이는 너무 과묵해서 주인님이 애교 시켜도 잘 안부려요 ㅠㅠ<br>  손 ! 코 ! 빵 ! 해도 묵묵부답...<br>  하지만 어디서든 적응을 잘 하는 똑똑한 댕댕이랍니다.'
  },
  {
    name: 'ISFP 이 순간 내가 제일 여유로운 댕댕이 ',
    desc: '성격이 너무 온화해서 웬만하면 잘 짖지 않아요~~<br>  또한 삶의 여유를 만끽할 수 있는 욜로 댕댕이랍니다'
  },
  {
    name: 'INFP 성실하고 이해심 넘치는 슈퍼 감성댕댕이',
    desc: '어떤 댕댕이보다도 주인님에 대한 이해심이 많고 개방적이라 혼자 상상도 많이해요~<br>  감정을 주인님한테 잘 표현하진 않지만 어떤 댕댕이보다도 내적 신념이 강하답니다!!'
  },
  {
    name: 'INTP 나는 호기심 대마왕 댕댕이',
    desc: '호기심이 많아서 이것 저것 다 해보는 댕댕이라<br>  가끔 주인님한테 혼날 때도 많아요 ㅠㅠ'
  },
  {
    name: 'ESTP 프로 느긋러 댕댕이',
    desc: '매사에 느긋느긋하고 관용적이라 주인님과 타협을 잘해요~~<br>  주인님이 간식 주면 나도 재롱 부려요~'
  },
  {
    name: 'ESFP 프로 경험러 댕댕이',
    desc: '호기심이 많아서 이것 저것 다 경험해보고 싶어요 ~~<br>  낯선 곳을 가도 잘 적응할 수 있는 나는야 호기심 대마왕 댕댕이 입니다. '
  },
  {
    name: 'ENFP 사교성 대마왕 똥꼬발랄 댕댕이',
    desc: '친화력이 뛰어나고 일상적인 활동엔 지루함을 느껴요 ㅠ.ㅠ<br>  누굴 만나든, 누구랑 있든 똥꼬발랄 그 자체 댕댕이라 <br> 주인님이 감당하기 힘들 수도 있어요 ~ '
  },
  {
    name: 'ENTP 독창적이고 똑똑한 댕댕이',
    desc: '하고 싶은 건 무조건 해야 직성이 풀려요 !<br>  어떻게 사고를 이렇게 독창적으로 칠 수 있지... 하는 생각이 들게 하는 댕댕이랍니다 :) '
  },
  {
    name: 'ESTJ 규칙을 잘 지키는 댕댕이',
    desc: '주인님 말이 곧 법 !! 주인님 말을 가장 잘 듣는 댕댕이에요~<br>  하지만 본인이 받아야 하는 게 있으면 무조건 받아야 하는 댕댕이랍니다  '
  },
  {
    name: 'ESFJ 사람이 너무 좋은 댕댕이',
    desc: '어린이랑도 잘 지내고 낯선 사람에게도 친절한 댕댕이에요~<br>  반려인과의 관계에서 행복을 느끼고 리액션이 정말 풍부해요 !!<br>  반려인이 바쁘면 토라져서 달래줘야 할 수도 있답니다 !! '
  },
  {
    name: 'ENFJ 사교적이지만 날 혼내면 짖는 댕댕이',
    desc: '처음 만나는 댕댕이 친구와도 금방 친해지고<br>  어린이랑도 잘 지내는 사교적인 댕댕이지만, 혼내면 으르렁 거려 가끔 무서운 댕댕이에요~<br>  하지만 따끔하게 혼내야 한다는 거 !! '
  },
  {
    name: 'ENTJ 준비성 철저 댕댕이',
    desc: '본인이 해야할 일에 철저한 준비를 거쳐야 행동으로 옮기는 댕댕이에요 !!<br>  또한 굉장히 활동적이고 주인님이 시키는 재롱을 다 하지만<br>  단호할 땐 엄청 단호한 댕댕이 랍니다!! '
  },
]

