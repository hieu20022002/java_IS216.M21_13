
# QUẢN LÍ SÂN THỂ THAO

Đây là đồ án của môn học Lập trình Java (IS216). Đề tài của đồ án là xây dựng một ứng dụng quản lí sân thể thao đáp ứng được những yêu cầu nghiệp vụ.

### Mục lục
 [1. Thành viên nhóm](#ThanhVienNhom)
 
 [2. Mục tiêu của đồ án](#MucTieu)
 
 [3. Các chức năng chính](#ChucNangChinh)
 
 [4. Chức năng](#ChucNang)
 
 [5. Chức năng Bonus](#ChucNangBonus)
 
 [6. Sơ đồ Usecase](#Usecase)
 
 [7. Mô hình dữ liệu](#MoHinhDL)
 
 [8. Cài đặt và sử dụng](#CaiDat)
 
 [9. Công nghệ sử dụng](#CongNgheSuDung)
 
 [10. Thư viện](#CongNgheSuDung)


<a name="ThanhVienNhom"></a>
## 1. Thành viên của nhóm

| STT | Họ tên | MSSV | SĐT | Vai trò |
|---|-------------------------|--------|-------|----------|
| 1 | Nguyễn Thị Kim Liên | 20520909 | 0795165646 | Trưởng nhóm |
| 2 | Nguyễn Ngọc Hiền | 20520496 | 0812922219 | Thành viên |
| 3 | Nguyễn Minh Hiếu | 20521326 | 0328357464 | Thành viên |
| 4 | Nguyễn Tô Đức Tài | 20520743 | 0352330676 | Thành viên |

<a name="MucTieu"></a>
## 2. Mục tiêu của đồ án

Ứng dụng phải đảm bảo được các mục tiêu:
+ Giúp nhân viên quản lí được sân thể thao từ thông tin về khách hàng, sân thể thao, dịch vụ đến lịch đặt, hóa đơn và chi tiêu
+ Giúp khách hàng có thể thực hiện đặt sân và gửi feedback phản hồi về độ hài lòng
+ Giao diện trực quan, dễ hiểu và rõ ràng
+ Xuất báo cáo, thống kê

<a name="ChucNangChinh"></a>
## 3. Các chức năng chính

+ Quản lí khách hàng
+ Quản lí nhân viên
+ Quản lí tài khoản của nhân viên và khách hàng
+ Quản lí sân thể thao
+ Quản lí dịch vụ bao gồm nước uống và dụng cụ thể thao
+ Quản lí lịch đặt sân
+ Quản lí hóa đơn
+ Quản lí chi tiêu
+ Quản lí feedback

<a name="ChucNang"></a>
## 4. Chức năng

Nhân viên:
+ Đăng nhập/Đăng kí tài khoản mới
+ Thêm/Xóa/Sửa thông tin như đồ uống, dụng cụ, sân thể thao, ...
+ Tìm kiếm, tra cứu thông tin về lịch đặt sân, đồ uống, dụng cụ, sân thể thao, ...
+ Xem báo cáo doanh thu theo tháng, quý
+ Xem thống kê top 5 khách hàng
+ Xem thống kê kho hàng về đồ uống và dụng cụ thể thao

Khách hàng:
+ Đăng nhập/Đăng kí tài khoản mới
+ Đặt lịch hoặc hủy lịch
+ Tra cứu, tìm kiếm lịch đặt
+ Gửi feedback

<a name="ChucNangBonus"></a>
## 5. Chức năng Bonus

+ Đặt sân và dịch vụ
+ Thanh toán

<a name="Usecase"></a>
## 6. Sơ đồ Usecase
![image](https://user-images.githubusercontent.com/81256065/174708636-d87ab6c1-8be5-44a8-8f5f-578e0909283c.png)

<a name="MoHinhDL"></a>
## 7. Mô hình dữ liệu
+ Mô hình thực thể mối kết hợp (ERD)
<img width="1095" alt="tt" src="https://user-images.githubusercontent.com/81256065/174708511-a46679c8-c6fb-4e1d-b96d-f9616f03081c.png">

+ Mô hình dữ liệu quan hệ (Physical Level)
<img width="928" alt="vl" src="https://user-images.githubusercontent.com/81256065/174708516-f07788d9-3825-4ae2-b719-a94bca617a55.png">

<a name="CaiDat"></a>
## 8. Cài đặt và sử dụng

<a name="CongNgheSuDung"></a>
## 9. Công nghệ sử dụng
+ NetBean
+ Oracle

<a name="CongNgheSuDung"></a>
## 10. Thư viện
+ JDBC
+ Commons Beanutils 1.8.0
+ Common Collections 2.1.1
+ Commons Digester 2.1
+ Commons Logging 1.1.1
+ Dom4j 1.6.1
+ Groovy All 2.0.1
+ Itextpdf 5.5.0
+ Jasperreports 5.5.0
+ Jasperreports Applet 5.5.0
+ Jasperreports Fonts 5.5.0
+ Jasperreports Javaflow 5.5.0
+ Javax Servlet 5.1.12
+ JCalendar 1.4

