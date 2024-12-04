package com.example.coffeerecomand;

import java.util.LinkedHashMap;

// 기존 구조와 이름을 유지한 인터페이스
public interface OnItemClickListner {
    // LinkedHashMap 요청을 처리하기 위한 메서드
    void onRequestLinkedHashMap(LinkedHashMap<String, Boolean> map);

    // 예/아니오 버튼 클릭 이벤트 처리
    void onYesClick(int position); // 예 버튼 클릭
    void onNoClick(int position); // 아니오 버튼 클릭
}
