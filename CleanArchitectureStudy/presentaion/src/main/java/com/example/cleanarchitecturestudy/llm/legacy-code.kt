package com.example.cleanarchitecturestudy.llm

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturestudy.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * 레거시 코드 : 25.04.28 기준 테스트 중 입니다.
 *
 * 테스트 중인 코드입니다. 빌드를 위해서 주석 처리 해두었습니다.
 * 해당 코드 사용 시, 주석을 풀고 테스트 해야합니다.
 */

/*
// 레거시 코드 - 리팩토링 필요
// 이 코드는 사용자 데이터를 관리하는 액티비티와 어댑터를 포함하고 있습니다.

// 전역 변수로 사용자 데이터 관리
var users = ArrayList<HashMap<String, Any>>()
var nextId = 1

class UserManagementActivity : AppCompatActivity() {
    // UI 요소들
    var userListView: ListView? = null
    var addButton: Button? = null
    var nameEditText: EditText? = null
    var ageEditText: EditText? = null
    var emailEditText: EditText? = null
    var filterAllButton: Button? = null
    var filterActiveButton: Button? = null
    var filterInactiveButton: Button? = null
    
    // 사용자 어댑터
    var userAdapter: UserAdapter? = null
    
    // 현재 필터 상태
    var currentFilter = "all"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_management)
        
        // UI 요소 초기화
        userListView = findViewById(R.id.user_list_view)
        addButton = findViewById(R.id.add_button)
        nameEditText = findViewById(R.id.name_edit_text)
        ageEditText = findViewById(R.id.age_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        filterAllButton = findViewById(R.id.filter_all_button)
        filterActiveButton = findViewById(R.id.filter_active_button)
        filterInactiveButton = findViewById(R.id.filter_inactive_button)
        
        // 어댑터 초기화
        userAdapter = UserAdapter(this, filterUsers(currentFilter))
        userListView?.adapter = userAdapter
        
        // 이벤트 리스너 설정
        addButton?.setOnClickListener {
            val name = nameEditText?.text.toString()
            val ageStr = ageEditText?.text.toString()
            val email = emailEditText?.text.toString()
            
            var age = 0
            if (ageStr.isNotEmpty()) {
                age = ageStr.toInt()
            }
            
            if (addUser(name, age, email)) {
                // 입력 필드 초기화
                nameEditText?.setText("")
                ageEditText?.setText("")
                emailEditText?.setText("")
                
                // 리스트 업데이트
                updateUserList()
            }
        }
        
        filterAllButton?.setOnClickListener {
            currentFilter = "all"
            updateUserList()
        }
        
        filterActiveButton?.setOnClickListener {
            currentFilter = "active"
            updateUserList()
        }
        
        filterInactiveButton?.setOnClickListener {
            currentFilter = "inactive"
            updateUserList()
        }
        
        // 샘플 데이터 추가
        addUser("홍길동", 30, "hong@example.com")
        addUser("김철수", 25, "kim@example.com")
        addUser("이영희", 28, "lee@example.com")
    }
    
    // 사용자 추가 함수
    fun addUser(name: String, age: Int, email: String): Boolean {
        if (name.isEmpty()) {
            Toast.makeText(this, "이름은 필수입니다!", Toast.LENGTH_SHORT).show()
            return false
        }
        
        if (email.isEmpty()) {
            Toast.makeText(this, "이메일은 필수입니다!", Toast.LENGTH_SHORT).show()
            return false
        }
        
        // 이메일 중복 체크
        for (i in 0 until users.size) {
            if (users[i]["email"] == email) {
                Toast.makeText(this, "이미 등록된 이메일입니다!", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        
        // 사용자 객체 생성
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val currentDate = dateFormat.format(Date())
        
        var newUser = HashMap<String, Any>()
        newUser["id"] = nextId
        newUser["name"] = name
        newUser["age"] = age
        newUser["email"] = email
        newUser["createdAt"] = currentDate
        newUser["active"] = true
        
        // 배열에 추가
        users.add(newUser)
        nextId++
        
        return true
    }
    
    // 사용자 삭제 함수
    fun deleteUser(id: Int) {
        for (i in 0 until users.size) {
            if (users[i]["id"] == id) {
                users.removeAt(i)
                break
            }
        }
        
        // 리스트 업데이트
        updateUserList()
    }
    
    // 사용자 활성 상태 토글 함수
    fun toggleActiveStatus(id: Int) {
        for (i in 0 until users.size) {
            if (users[i]["id"] == id) {
                val isActive = users[i]["active"] as Boolean
                users[i]["active"] = !isActive
                break
            }
        }
        
        // 리스트 업데이트
        updateUserList()
    }
    
    // 사용자 필터링 함수
    fun filterUsers(status: String): ArrayList<HashMap<String, Any>> {
        var filteredUsers = ArrayList<HashMap<String, Any>>()
        
        if (status == "all") {
            // ArrayList는 참조 타입이므로 새 인스턴스를 생성하여 반환
            filteredUsers.addAll(users)
        } else if (status == "active") {
            for (i in 0 until users.size) {
                if (users[i]["active"] == true) {
                    filteredUsers.add(users[i])
                }
            }
        } else if (status == "inactive") {
            for (i in 0 until users.size) {
                if (users[i]["active"] == false) {
                    filteredUsers.add(users[i])
                }
            }
        }
        
        return filteredUsers
    }
    
    // 리스트 업데이트 함수
    fun updateUserList() {
        val filteredUsers = filterUsers(currentFilter)
        userAdapter = UserAdapter(this, filteredUsers)
        userListView?.adapter = userAdapter
    }
    
    // 편집 폼 열기 함수
    fun openEditForm(id: Int) {
        var userToEdit: HashMap<String, Any>? = null
        
        // 사용자 찾기
        for (i in 0 until users.size) {
            if (users[i]["id"] == id) {
                userToEdit = users[i]
                break
            }
        }
        
        if (userToEdit != null) {
            // 편집 다이얼로그 생성
            val dialogView = layoutInflater.inflate(R.layout.dialog_edit_user, null)
            
            val nameEditText = dialogView.findViewById<EditText>(R.id.edit_name)
            val ageEditText = dialogView.findViewById<EditText>(R.id.edit_age)
            val emailEditText = dialogView.findViewById<EditText>(R.id.edit_email)
            
            nameEditText.setText(userToEdit["name"].toString())
            ageEditText.setText(userToEdit["age"].toString())
            emailEditText.setText(userToEdit["email"].toString())
            
            val dialog = AlertDialog.Builder(this)
                .setTitle("사용자 수정")
                .setView(dialogView)
                .setPositiveButton("저장") { _, _ ->
                    val name = nameEditText.text.toString()
                    val ageStr = ageEditText.text.toString()
                    val email = emailEditText.text.toString()
                    
                    var age = 0
                    if (ageStr.isNotEmpty()) {
                        age = ageStr.toInt()
                    }
                    
                    updateUser(id, name, age, email)
                }
                .setNegativeButton("취소", null)
                .create()
            
            dialog.show()
        }
    }
    
    // 사용자 업데이트 함수
    fun updateUser(id: Int, name: String, age: Int, email: String): Boolean {
        if (name.isEmpty()) {
            Toast.makeText(this, "이름은 필수입니다!", Toast.LENGTH_SHORT).show()
            return false
        }
        
        if (email.isEmpty()) {
            Toast.makeText(this, "이메일은 필수입니다!", Toast.LENGTH_SHORT).show()
            return false
        }
        
        var userFound = false
        
        for (i in 0 until users.size) {
            if (users[i]["id"] == id) {
                // 이메일 중복 체크 (현재 사용자 제외)
                for (j in 0 until users.size) {
                    if (users[j]["id"] != id && users[j]["email"] == email) {
                        Toast.makeText(this, "이미 등록된 이메일입니다!", Toast.LENGTH_SHORT).show()
                        return false
                    }
                }
                
                users[i]["name"] = name
                users[i]["age"] = age
                users[i]["email"] = email
                
                // 업데이트 날짜 추가
                val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
                val currentDate = dateFormat.format(Date())
                users[i]["updatedAt"] = currentDate
                
                userFound = true
                break
            }
        }
        
        if (!userFound) {
            Toast.makeText(this, "사용자를 찾을 수 없습니다!", Toast.LENGTH_SHORT).show()
            return false
        }
        
        // 리스트 업데이트
        updateUserList()
        
        return true
    }
}

// 사용자 어댑터 클래스
class UserAdapter(context: Context, users: ArrayList<HashMap<String, Any>>) : BaseAdapter() {
    private var context: Context
    private var users: ArrayList<HashMap<String, Any>>
    private var inflater: LayoutInflater
    
    init {
        this.context = context
        this.users = users
        this.inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    
    override fun getCount(): Int {
        return users.size
    }
    
    override fun getItem(position: Int): Any {
        return users[position]
    }
    
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        
        if (view == null) {
            view = inflater.inflate(R.layout.item_user, parent, false)
        }
        
        val user = users[position]
        
        val nameTextView = view!!.findViewById<TextView>(R.id.name_text_view)
        val ageTextView = view.findViewById<TextView>(R.id.age_text_view)
        val emailTextView = view.findViewById<TextView>(R.id.email_text_view)
        val activeToggleButton = view.findViewById<Button>(R.id.active_toggle_button)
        val deleteButton = view.findViewById<Button>(R.id.delete_button)
        val editButton = view.findViewById<Button>(R.id.edit_button)
        
        nameTextView.text = "${user["name"]} (${user["age"]}세)"
        emailTextView.text = user["email"].toString()
        
        val isActive = user["active"] as Boolean
        activeToggleButton.text = if (isActive) "비활성화" else "활성화"
        
        // 클릭 이벤트 설정
        activeToggleButton.setOnClickListener {
            (context as UserManagementActivity).toggleActiveStatus(user["id"] as Int)
        }
        
        deleteButton.setOnClickListener {
            (context as UserManagementActivity).deleteUser(user["id"] as Int)
        }
        
        editButton.setOnClickListener {
            (context as UserManagementActivity).openEditForm(user["id"] as Int)
        }
        
        return view
    }
}

*/