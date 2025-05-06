const body = document.querySelector("body"),
      modeToggle = body.querySelector(".mode-toggle");
      sidebar = body.querySelector("nav");
      sidebarToggle = body.querySelector(".sidebar-toggle");
let getMode = localStorage.getItem("mode");
if(getMode && getMode ==="dark"){
    body.classList.toggle("dark");
}
let getStatus = localStorage.getItem("status");
if(getStatus && getStatus ==="close"){
    sidebar.classList.toggle("close");
}
modeToggle.addEventListener("click", () =>{
    body.classList.toggle("dark");
    if(body.classList.contains("dark")){
        localStorage.setItem("mode", "dark");
    }else{
        localStorage.setItem("mode", "light");
    }
});
sidebarToggle.addEventListener("click", () => {
    sidebar.classList.toggle("close");
    if(sidebar.classList.contains("close")){
        localStorage.setItem("status", "close");
    }else{
        localStorage.setItem("status", "open");
    }
})



async function loadSoLieuThongKe() {
    try {
        const response = await fetch('/api/admin/thongKe', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Không thể lấy số liệu thống kê');
        }

        const stats = await response.json();

        // Cập nhật số liệu vào giao diện
        document.getElementById('sinhVienNum').textContent = stats.sinhVienCount.toLocaleString();
        document.getElementById('conTyNum').textContent = stats.doanhNghiepCount.toLocaleString();
        document.getElementById('baoCaoNum').textContent = stats.baoCaoCount.toLocaleString();

    } catch (error) {
        console.error('Lỗi khi tải số liệu thống kê:', error);
        alert('Đã có lỗi xảy ra: ' + error.message);
    }
}


// Gọi cả hai hàm khi trang được tải
document.addEventListener('DOMContentLoaded', () => {
    loadSoLieuThongKe();
});




async function loadSinhVienList() {
    try {
        const response = await fetch('/api/admin/sinhVienList', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Không thể lấy danh sách sinh viên');
        }

        const sinhViens = await response.json();

        // Lấy phần tử activity-data
        const activityData = document.querySelector('.activity-data');
        activityData.innerHTML = ''; // Xóa nội dung hiện tại

        // Tạo các cột tiêu đề
        activityData.innerHTML = `
            <div class="data names">
                <span class="data-title">Họ tên</span>
            </div>
            <div class="data email">
                <span class="data-title">Email</span>
            </div>
            <div class="data joined">
                <span class="data-title">Trường</span>
            </div>
            <div class="data type">
                <span class="data-title">Mã số sinh viên</span>
            </div>
            <div class="data status">
                <span class="data-title">Trạng thái</span>
            </div>
        `;

        // Thêm dữ liệu sinh viên
        sinhViens.forEach(sinhVien => {
            activityData.querySelector('.data.names').innerHTML += `<span class="data-list">${sinhVien.hoTen}</span>`;
            activityData.querySelector('.data.email').innerHTML += `<span class="data-list">${sinhVien.email}</span>`;
            activityData.querySelector('.data.joined').innerHTML += `<span class="data-list">${sinhVien.truong}</span>`;
            activityData.querySelector('.data.type').innerHTML += `<span class="data-list">${sinhVien.mssv}</span>`;
            activityData.querySelector('.data.status').innerHTML += `<span class="data-list">${sinhVien.taiKhoan.trangThai  == true ? 'active' : 'inactive'}</span>`; // Giả định trạng thái
        });

    } catch (error) {
        console.error('Lỗi khi tải danh sách sinh viên:', error);
        alert('Đã có lỗi xảy ra: ' + error.message);
    }
}




function QLSinhVien() {
    
}








async function loadCongTyList() {
    try {
        const response = await fetch('/api/admin/congTyList', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Không thể lấy danh sách công ty');
        }

        const congTys = await response.json();

        // Lấy phần tử activity-data
        const activityData = document.querySelector('.activity-data');
        activityData.innerHTML = ''; // Xóa nội dung hiện tại

        // Tạo các cột tiêu đề
        activityData.innerHTML = `
            <div class="data names">
                <span class="data-title">Tên công ty</span>
            </div>
            <div class="data email">
                <span class="data-title">Email</span>
            </div>
            <div class="data joined">
                <span class="data-title">Lĩnh vực</span>
            </div>
            <div class="data type">
                <span class="data-title">Mô tả</span>
            </div>
            <div class="data status">
                <span class="data-title">Trạng thái</span>
            </div>
        `;

        // Thêm dữ liệu công ty
        congTys.forEach(congTy => {
            activityData.querySelector('.data.names').innerHTML += `<span class="data-list">${congTy.tenDN}</span>`;
            activityData.querySelector('.data.email').innerHTML += `<span class="data-list">${congTy.email}</span>`;
            activityData.querySelector('.data.joined').innerHTML += `<span class="data-list">${congTy.linhVuc}</span>`;
            activityData.querySelector('.data.type').innerHTML += `<span class="data-list">${congTy.moTa}</span>`;
            activityData.querySelector('.data.status').innerHTML += `<span class="data-list">${congTy.taiKhoan.trangThai  == true ? 'active' : 'inactive'}</span>`; // Giả định trạng thái
        });

    } catch (error) {
        console.error('Lỗi khi tải danh sách công ty:', error);
        alert('Đã có lỗi xảy ra: ' + error.message);
    }
}