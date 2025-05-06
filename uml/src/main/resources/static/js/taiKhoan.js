
var phanQuyenNum = 1;

function phanQuyen(num) {
  // Reset nút
  document.getElementById("btnSinhVien").classList.remove("active");
  document.getElementById("btnDoanhNghiep").classList.remove("active");

  // Ẩn cả 2 form
  document.querySelector(".dangKy--sinhVien").style.display = "none";
  document.querySelector(".dangKy--doanhNghiep").style.display = "none";

  // Hiển thị & tô màu nút tương ứng
  if (num === 1) {
    document.getElementById("btnSinhVien").classList.add("active");
    document.querySelector(".dangKy--sinhVien").style.display = "block";
  } else {
    document.getElementById("btnDoanhNghiep").classList.add("active");
    document.querySelector(".dangKy--doanhNghiep").style.display = "block";
  }
  phanQuyenNum = num;
}

// Tự động gọi để hiện sẵn sinh viên khi tải trang
window.onload = function () {
  phanQuyen(1);
}




async function dangKy(event) {
  event.preventDefault();

  const form = document.querySelector('form');
  let data, url;




  if (phanQuyenNum === 1) {
    let m_matKhau = form.querySelector('.dangKy--sinhVien input[placeholder="Mật khẩu"]').value;
    const m_xacNhanMatKhau = form.querySelector('.dangKy--sinhVien input[placeholder="Xác nhận mật khẩu"]').value;

    if (m_matKhau !== m_xacNhanMatKhau) {
      alert('Mật khẩu và xác nhận mật khẩu không trùng khớp');
      return;
    }

    data = {
      hoTen: form.querySelector('.dangKy--sinhVien input[placeholder="Họ và tên"]').value,
      mssv: form.querySelector('.dangKy--sinhVien input[placeholder="Mã số sinh viên"]').value,
      truong: form.querySelector('.dangKy--sinhVien input[placeholder="Trường"]').value,
      email: form.querySelector('.dangKy--sinhVien input[placeholder="Email"]').value,
      tenDangNhap: form.querySelector('.dangKy--sinhVien input[placeholder="Tên đăng nhập"]').value,
      matKhau: form.querySelector('.dangKy--sinhVien input[placeholder="Mật khẩu"]').value,
    };
    url = '/api/dangky/sinhvien';
  } else if (phanQuyenNum === 2) {

    const m_matKhau = form.querySelector('.dangKy--doanhNghiep input[placeholder="Mật khẩu"]').value;
    const m_xacNhanMatKhau = form.querySelector('.dangKy--doanhNghiep input[placeholder="Xác nhận mật khẩu"]').value;

    if (m_matKhau !== m_xacNhanMatKhau) {
      alert('Mật khẩu và xác nhận mật khẩu không trùng khớp');
      return;
    }

    data = {
      tenDoanhNghiep: form.querySelector('.dangKy--doanhNghiep input[placeholder="Tên công ty"]').value,
      email: form.querySelector('.dangKy--doanhNghiep input[placeholder="Email"]').value,
      tenDangNhap: form.querySelector('.dangKy--doanhNghiep input[placeholder="Tên đăng nhập"]').value,
      matKhau: form.querySelector('.dangKy--doanhNghiep input[placeholder="Mật khẩu"]').value,
    };
    url = '/api/dangky/doanhnghiep';
  }


  try {
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });

    const result = await response.text();
    alert(result);
    if(result.includes("thành công")) {
      window.location.href = '/dangNhap';
    }
  } catch (error) {
    alert('Đã có lỗi xảy ra: ' + error.message);
  }

}


async function dangNhap(event) {
  event.preventDefault();

  const form = document.querySelector('form');
  const tenDangNhap = form.querySelector('input[placeholder="Tên đăng nhập"]').value;
  const matKhau = form.querySelector('input[placeholder="Mật khẩu"]').value;

  const data = {
      tenDangNhap,
      matKhau
  };

  try {
      const response = await fetch('/api/dangnhap', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(data)
      });

      const result = await response.json();
        alert(result.message);

        if (result.message.includes("thành công")) {
            const vaiTro = result.vaiTro;
            if (vaiTro === "SinhVien") {
                window.location.href = '/sinhvien/trangChu';
            } else if (vaiTro === "DoanhNghiep") {
                window.location.href = '/doanhnghiep/doanhNghiepTrangChu';
            } else if (vaiTro === "Admin") {
                window.location.href = '/admin';
            } else {
                alert('Vai trò không hợp lệ!');
            }
        }
  } catch (error) {
      alert('Đã có lỗi xảy ra: ' + error.message);
  }
}



function logout() {
  window.location.href = '/index'; // Chuyển hướng về trang đăng nhập
}
