# **커피 매뉴얼**
![Android](https://img.shields.io/badge/Android-3DDC84?logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white)
![Figma](https://img.shields.io/badge/Figma-F24E1E?logo=figma&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white)

---

간단한 안드로이드 애플리케이션으로, 커피 메뉴를 보여줍니다.

---

## **클래스 및 주요 함수/변수**

### **1. `MainActivity`**  
앱의 메인 액티비티로, RecyclerView 초기화와 이미지 클릭 및 드래그 앤 드롭 재정렬 기능을 관리합니다.

#### **주요 변수**
- **`LinkedHashMap<Integer, Boolean> imageClickStatus`**  
  각 이미지 리소스 ID의 클릭 상태(`true`/`false`)를 추적합니다.

- **`RecyclerView recyclerView`**  
   데이터를 나열해서 보여줄 RecyclerView입니다.

- **`ImageAdapter adapter`**  
  데이터를 RecyclerView에 바인딩합니다.

- **`String[] drinks`**  
  음료 이름 목록을 저장합니다. 

- **`int[] images`**  
  각 음료에 해당하는 이미지 리소스 ID를 저장합니다.

#### **주요 함수**
- **`onCreate(Bundle savedInstanceState)`**
  - RecyclerView 및 어댑터를 초기화합니다.
  - 이미지가 클릭됐는지 판단하는 LinkedHashMap`imageClickStatus`를 설정합니다.
  - `ItemTouchHelper`를 통해 드래그 앤 드롭 기능을 구현합니다.

- **`initializeImageClickStatus()`**
  - `LinkedHashMap`을 초기화하고 각 이미지 리소스 ID의 클릭 상태를 `false`로 설정합니다.

- **`setupItemTouchHelper()`**
  - RecyclerView 항목의 드래그 앤 드롭 재정렬을 구현합니다.
  - 드래그 이벤트 발생 시 `drinks`와 `images` 배열의 순서를 업데이트하고 UI를 새로 고칩니다.

---

### **2. `ImageAdapter`**  
RecyclerView의 어댑터로, 음료 이름과 이미지를 UI에 바인딩하고 클릭 이벤트를 처리합니다.

#### **주요 변수**
- **`String[] drinks`**  
  RecyclerView에 표시될 음료 이름 목록입니다.

- **`int[] imageList`**  
  RecyclerView에 표시될 이미지 리소스 ID 목록입니다.

- **`LinkedHashMap<Integer, Boolean> imageClickStatus`**  
  각 이미지의 클릭 상태를 추적합니다.

#### **주요 함수**
- **`ImageAdapter(String[] drinks, int[] imageList, LinkedHashMap<Integer, Boolean> imageClickStatus)`**
  - 음료 이름, 이미지, 클릭 상태를 초기화하는 생성자입니다. 이미지의 id를 key로, OnClick 여부를 value로 습니다.

- **`onCreateViewHolder(ViewGroup parent, int viewType)`**
  - 각 RecyclerView 항목에 레이아웃(`item.xml`)을 생성합니다.

- **`onBindViewHolder(ViewHolder holder, int position)`**
  - UI 컴포넌트에 데이터를 바인딩합니다.
  - 클릭 상태에 따라 이미지 크기를 조정합니다.
  - 이미지 클릭 이벤트를 처리하고 클릭 상태를 업데이트합니다.

- **`getItemCount()`**
  - RecyclerView 항목의 개수를 반환합니다.

---

### **3. `OnItemClickListener` (인터페이스)**  
RecyclerView 항목의 클릭 이벤트를 처리합니다.

#### **주요 함수**
- **`onItemClick(int position)`**
  - 항목이 클릭되었을 때 위치 정보를 전달하여 추가 작업을 수행합니다.

---

### **4. 레이아웃 XML 파일**

#### **`activity_main.xml`**
- **구성 요소**:
  - `RecyclerView`: 음료 리스트를 표시합니다.
  - `LinearLayout` 또는 `RelativeLayout`: 전체 레이아웃을 정의합니다.

#### **`item.xml`**
- **구성 요소**:
  - `ImageView`: 음료 이미지를 표시합니다.
  - `TextView`: 음료 이름을 표시합니다.

---

## **클래스 간의 상호작용**

1. **`MainActivity`**
   - RecyclerView와 `ImageAdapter`를 관리합니다.
   - `LinkedHashMap`을 통해 음료 데이터와 클릭 상태를 저장합니다.
   - `ItemTouchHelper`를 통해 드래그 앤 드롭 재정렬을 처리합니다.

2. **`ImageAdapter`**
   
   - 이미지 클릭 이벤트를 처리하고 동적으로 이미지 크기를 조정합니다.
   - MainActivity로부터 값을 받아 RecyclerView 항목의 UI를 업데이트합니다.

3. **`OnItemClickListener`**  
   - 콜백 함수 구현을 위한 Interface

---



