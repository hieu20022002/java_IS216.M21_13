/*==============================================================*/
/*                          DATA                                */
/*==============================================================*/

REM INSERTING into USER_ACCOUNT
SET DEFINE OFF;
---Customer account---
Insert into USER_ACCOUNT values ('avan123','123456','Khách Hàng');
Insert into USER_ACCOUNT values ('hungnn059','12345678','Khách Hàng');
Insert into USER_ACCOUNT values ('antv746','an123456','Khách Hàng');
Insert into USER_ACCOUNT values ('thanhtt912','thanh96435','Khách Hàng');
Insert into USER_ACCOUNT values ('linhknt276','linh12345@','Khách Hàng');
Insert into USER_ACCOUNT values ('maitp142','9876543','Khách Hàng');
Insert into USER_ACCOUNT values ('thanhtl789','ht1234ht','Khách Hàng');
Insert into USER_ACCOUNT values ('hungmn202','100702@mn','Khách Hàng');
Insert into USER_ACCOUNT values ('baogn227','gbbaooo321','Khách Hàng');
Insert into USER_ACCOUNT values ('tienmt147','tienmt8756','Khách Hàng');
Insert into USER_ACCOUNT values ('minhnn234','minh99445','Khách Hàng');
Insert into USER_ACCOUNT values ('thaotn445','0986523451','Khách Hàng');
Insert into USER_ACCOUNT values ('duongtn200','2000000098','Khách Hàng');
Insert into USER_ACCOUNT values ('chaubt145','chau123456','Khách Hàng');
Insert into USER_ACCOUNT values ('nguyenmt98','123456789','Khách Hàng');

---Staff account---
Insert into USER_ACCOUNT values ('hieumn059','hieu123456','Quản Lý');
Insert into USER_ACCOUNT values ('lienktn333','ntkl98372','Nhân Viên');
Insert into USER_ACCOUNT values ('hiennn781','hiennn1234567','Nhân Viên');
Insert into USER_ACCOUNT values ('taidtn262','tai08621','Nhân Viên');
Insert into USER_ACCOUNT values ('minhvn586','minh6789','Nhân Viên');

REM INSERTING into CUSTOMER
SET DEFINE OFF;
Insert into CUSTOMER values ('KH001','avan123','Nguyễn Văn A','0812348213','Thủ Đức, TP.HCM','13','Vãng lai',null);
Insert into CUSTOMER values ('KH002','hungnn059','Nguyễn Ngọc Hưng','0366697041','Quận 1, TP.HCM','24','Vãng lai',null);
Insert into CUSTOMER values ('KH003','antv746','Võ Thành An','0394940803','Gò Vấp, TP.HCM','80','VIP',null);
Insert into CUSTOMER values ('KH004','thanhtt912','Trần Tiến Thành','0703824364','Thủ Đức, TP.HCM','70','VIP',null);
Insert into CUSTOMER values ('KH005','linhknt276','Trần Ngô Khánh Linh','0987927070','Tân Bình, TP.HCM','5','Vãng lai',null);
Insert into CUSTOMER values ('KH006','maitp142','Phạm Thanh Mai','0784982989','Thủ Đức, TP.HCM','10','Vãng lai',null);
Insert into CUSTOMER values ('KH007','thanhtl789','Lê Trung Thành','0788385467','Quận 2, TP.HCM','50','Thân thiết',null);
Insert into CUSTOMER values ('KH008','hungmn202','Nguyễn Minh Hưng','0986523479','Tân Phú ,TP.HCM','1','Vãng lai',null);
Insert into CUSTOMER values ('KH009','baogn227','Ngô Gia Bảo','0703452147','Gò Vấp, TP.HCM','72','VIP',null);
Insert into CUSTOMER values ('KH010','tienmt147','Trần Minh Tiến','0812765234','Quận 5, TP.HCM','2','Vãng lai',null);
Insert into CUSTOMER values ('KH011','minhnn234','Nguyễn Ngọc Minh','0943799445','Quận 4, TP.HCM','55','Thân thiết',null);
Insert into CUSTOMER values ('KH012','thaotn445','Nguyễn Thị Thảo','0986523451','Quận 12, TP.HCM','5','Vãng lai',null);
Insert into CUSTOMER values ('KH013','duongtn200','Nguyễn Tùng Dương','0384967632','Thủ Đức, TP.HCM','34','Vãng lai',null);
Insert into CUSTOMER values ('KH014','chaubt145','Trần Bảo Châu','0392652325','Dĩ An, Bình Dương','9','Vãng lai',null);
Insert into CUSTOMER values ('KH015','nguyenmt98','Nguyễn Trần Minh Nguyên','0786182859','Phú Nhuận, TP.HCM','60','Thân thiết',null);

REM INSERTING into STAFF
SET DEFINE OFF;
Insert into STAFF values ('NV001','hieumn059', null,'Nguyễn Minh Hiếu','0381523687','Dĩ An, Bình Dương',to_date('20-04-2019','DD-MM-RRRR'),'Quản lý',null);
Insert into STAFF values ('NV002','lienktn333','NV001','Nguyễn Thị Kim Liên','0962371245','Thủ Đức, TP.HCM',to_date('31-12-2021','DD-MM-RRRR'),'Nhân viên',null);
Insert into STAFF values ('NV003','hiennn781','NV001','Nguyễn Ngọc Hiền','0953726534','Thủ Đức, TP.HCM',to_date('07-09-2021','DD-MM-RRRR'),'Nhân viên',null);
Insert into STAFF values ('NV004','taidtn262','NV001','Nguyễn Tô Đức Tài','0895476542','Dĩ An, Bình Dương',to_date('09-12-2021','DD-MM-RRRR'),'Nhân viên',null);
Insert into STAFF values ('NV005','minhvn586','NV001','Nguyễn Văn Minh','0895632145','Quận 9, TP.HCM',to_date('09-12-2021','DD-MM-RRRR'),'Nhân viên',null);

REM INSERTING into FEEDBACK
SET DEFINE OFF;
Insert into FEEDBACK values ('FB01 ','KH001','5',' ',null);
Insert into FEEDBACK values ('FB02 ','KH002','4',' ',null);
Insert into FEEDBACK values ('FB03 ','KH003','3',' ',null);
Insert into FEEDBACK values ('FB04 ','KH004','5',' ',null);
Insert into FEEDBACK values ('FB05 ','KH005','4',' ',null);
Insert into FEEDBACK values ('FB06 ','KH006','5',' ',null);
Insert into FEEDBACK values ('FB07 ','KH007','5',' ',null);
Insert into FEEDBACK values ('FB08 ','KH008','5',' ',null);
Insert into FEEDBACK values ('FB09 ','KH009','5',' ',null);
Insert into FEEDBACK values ('FB10 ','KH010','5',' ',null);
Insert into FEEDBACK values ('FB11 ','KH011','2',' ',null);
Insert into FEEDBACK values ('FB12 ','KH012','4',' ',null);
Insert into FEEDBACK values ('FB13 ','KH013','5',' ',null);
Insert into FEEDBACK values ('FB14 ','KH014','5',' ',null);
Insert into FEEDBACK values ('FB15 ','KH015','1',' ',null);
Insert into FEEDBACK values ('FB16 ','KH002','4',' ',null);
Insert into FEEDBACK values ('FB17 ','KH002','2',' ',null);
Insert into FEEDBACK values ('FB18 ','KH010','3',' ',null);
Insert into FEEDBACK values ('FB19 ','KH015','2',' ',null);
Insert into FEEDBACK values ('FB20 ','KH001','4',' ',null);

REM INSERTING into FIELD
SET DEFINE OFF;
Insert into FIELD values ('CL01 ','Sân cầu lông đơn','13,4x5,18','80000','Đang thuê',null);
Insert into FIELD values ('CL02 ','Sân cầu lông đôi','13,4x6,1','100000','Trống',null);
Insert into FIELD values ('BB01 ','Sân bóng bàn','14x7','80000','Trống',null);
Insert into FIELD values ('BR01 ','Sân bóng rổ 3x3','15x11','80000','Trống',null);
Insert into FIELD values ('BR02 ','Sân bóng rổ 5x5','28x15','100000','Trống',null);
Insert into FIELD values ('SB01 ','Sân bóng đá 11 người','105x68','300000','Đang thuê',null);
Insert into FIELD values ('SB02 ','Sân bóng đá 7 người','50x30','250000','Trống',null);
Insert into FIELD values ('SB03 ','Sân futsal','40x20','200000','Trống',null);
Insert into FIELD values ('TN01 ','Sân tennis đơn','23,77x8,23','150000','Đang thuê',null);
Insert into FIELD values ('TN02 ','Sân tennis đôi','23,77x10,97','120000','Đang thuê',null);
Insert into FIELD values ('BC01 ','Sân bóng chuyền','18x9','200000','Đang thuê',null);
Insert into FIELD values ('BN01 ','Sân bóng ném','30x17','100000','Đang thuê',null);


REM INSERTING into BEVERAGE
SET DEFINE OFF;
Insert into BEVERAGE  values ('BE01 ','Nước khoáng đóng chai 500ml','150','3000',null);
Insert into BEVERAGE  values ('BE02 ','Nước khoáng đóng chai 1,5l','130','5000',null);
Insert into BEVERAGE  values ('BE03 ','Redbull','160','12000',null);
Insert into BEVERAGE  values ('BE04 ','Carabao','140','14000',null);
Insert into BEVERAGE  values ('BE05 ','Number 1','100','10000',null);
Insert into BEVERAGE  values ('BE06 ','Sting','60','9000',null);
Insert into BEVERAGE  values ('BE07 ','C2','70','9000',null);
Insert into BEVERAGE  values ('BE08 ','Coca Cola','100','10000',null);
Insert into BEVERAGE  values ('BE09 ','Coca Cola Zero Sugar','100','12000',null);
Insert into BEVERAGE  values ('BE10 ','Pepsi','20','10000',null);
Insert into BEVERAGE  values ('BE11 ','Trà xanh 0 độ','100','10000',null);
Insert into BEVERAGE  values ('BE12 ','7up','5','10000',null);
Insert into BEVERAGE  values ('BE13 ','7up Free Calo','100','12000',null);

REM INSERTING into EQUIPMENT
SET DEFINE OFF;
Insert into EQUIPMENT values ('EQ01 ','Vợt Tennis','20','45000',null);
Insert into EQUIPMENT values ('EQ02 ','Quần áo bóng đá','100','10000',null);
Insert into EQUIPMENT values ('EQ03 ','Giày tennis','20','45000',null);
Insert into EQUIPMENT values ('EQ04 ','Bóng chuyền','22','10000',null);
Insert into EQUIPMENT values ('EQ05 ','Bóng rổ','15','10000',null);
Insert into EQUIPMENT values ('EQ06 ','Quần áo tennis','23','10000',null);
Insert into EQUIPMENT values ('EQ07 ','Bóng đá','15','10000',null);
Insert into EQUIPMENT values ('EQ08 ','Bóng tennis','25','10000',null);
Insert into EQUIPMENT values ('EQ09 ','Vợt bóng bàn','35','30000',null);
Insert into EQUIPMENT values ('EQ10 ','Giày bóng đá','50','50000',null);
Insert into EQUIPMENT values ('EQ11 ','Giày bóng rổ','15','10000',null);
Insert into EQUIPMENT values ('EQ12 ','Bóng ném','15','10000',null);
Insert into EQUIPMENT values ('EQ13 ','Vợt cầu lông ','30','45000',null);
Insert into EQUIPMENT values ('EQ14 ','Bóng bàn','20','10000',null);
Insert into EQUIPMENT values ('EQ15 ','Găng tay thủ môn','10','20000',null);

REM INSERTING into SCHEDULE
SET DEFINE OFF;
Insert into SCHEDULE  values ('BK01 ','NV002','KH001',to_date('05-04-2022','DD-MM-RRRR'),'Đã đặt','Chưa thanh toán',null);
Insert into SCHEDULE  values ('BK02 ','NV003','KH004',to_date('04-04-2022','DD-MM-RRRR'),'Đã hủy','Chưa thanh toán',null);
Insert into SCHEDULE  values ('BK03 ','NV003','KH002',to_date('06-04-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK04 ','NV004','KH001',to_date('13-04-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK05 ','NV003','KH006',to_date('13-04-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK06 ','NV005','KH008',to_date('13-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK07 ','NV005','KH010',to_date('13-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK08 ','NV002','KH011',to_date('25-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK09 ','NV004','KH008',to_date('01-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK10 ','NV003','KH015',to_date('30-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK11 ','NV004','KH014',to_date('19-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK12 ','NV005','KH012',to_date('13-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK13 ','NV004','KH003',to_date('13-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK14 ','NV003','KH005',to_date('11-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);
Insert into SCHEDULE  values ('BK15 ','NV005','KH006',to_date('13-05-2022','DD-MM-RRRR'),'Đã đặt','Đã thanh toán',null);

REM INSERTING into BILL
SET DEFINE OFF;
Insert into BILL VALUES ('B001', 'NV003', 'KH002', 'Trực tuyến', to_date('06-04-2022','DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B002', 'NV004', 'KH001', 'Trực tiếp', to_date('16-04-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B003', 'NV003', 'KH006', 'Trực tiếp', to_date('23-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B004', 'NV005', 'KH008', 'Trực tiếp', to_date('14-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B005', 'NV005', 'KH010', 'Trực tiếp', to_date('14-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B006', 'NV002', 'KH011', 'Trực tiếp', to_date('30-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B007', 'NV004', 'KH008', 'Trực tiếp', to_date('16-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B008', 'NV003', 'KH015', 'Trực tuyến', to_date('30-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B009', 'NV004', 'KH014', 'Trực tuyến', to_date('19-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B010', 'NV005', 'KH012', 'Trực tuyến', to_date('13-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B011', 'NV004', 'KH003', 'Trực tuyến', to_date('13-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B012', 'NV003', 'KH005', 'Trực tuyến', to_date('11-05-2022', 'DD-MM-RRRR'), 0, null);
Insert into BILL VALUES ('B013', 'NV005', 'KH006', 'Trực tuyến', to_date('13-05-2022', 'DD-MM-RRRR'), 0, null);

REM INSERTING into SCHEDULEDETAILS
SET DEFINE OFF;
Insert into SCHEDULEDETAILS  values ('BK01 ', null,'SB02 ','BE02 ','EQ02 ','12','15','30', to_date('05-04-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK02 ', null,'TN02 ','BE04 ','EQ01 ','2','17','60', to_date('06-04-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK03 ','B001','BC01 ','BE01 ','EQ04 ','12','18','90', to_date('07-04-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK04 ','B002','TN01 ','BE05 ','EQ01 ','2','19','60', to_date('16-04-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK05 ','B003','CL02 ','BE06 ','EQ13 ','4','2','30', to_date('23-05-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK06 ','B004','CL01 ','BE02 ','EQ13 ','2','4','120', to_date('14-05-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK07 ','B005','SB03 ','BE13 ', null,'3','0','30', to_date('14-05-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK08 ','B006','BB01 ',null,'EQ09 ','0','2','60', to_date('30-05-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK09 ','B007','BN01 ',null, null,'0','0','30', to_date('16-05-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK10 ','B008','BN01 ',null, null,'0','0','30', to_date('01-06-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK11 ','B009','SB01 ','BE01', 'EQ10','7','4','90', to_date('20-05-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK12 ','B010','BN01 ',null, null,'0','0','120', to_date('26-06-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK13 ','B011','BR01 ','BE09', null,'4','0','150', to_date('01-06-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK14 ','B012','BN01 ',null, null,'0','0','30', to_date('18-05-2022','DD-MM-RRRR'));
Insert into SCHEDULEDETAILS  values ('BK15 ','B013','SB02 ',null, null,'0','0','60', to_date('14-05-2022','DD-MM-RRRR'));

REM INSERTING into EXPENSE
SET DEFINE OFF;
Insert into EXPENSE VALUES ('E001', 'NV003','Nhập 20 vợt cầu lông mới','2000000', to_date('06-04-2022','DD-MM-RRRR'),  null);
Insert into EXPENSE VALUES ('E002', 'NV004', 'Sửa sân BR01','800000', to_date('16-04-2022', 'DD-MM-RRRR'),  null);
Insert into EXPENSE VALUES ('E003', 'NV002', 'Thay đèn CL01','200000', to_date('16-05-2022', 'DD-MM-RRRR'),  null);
Insert into EXPENSE VALUES ('E004', 'NV005', 'Nhập 20 thùng 7up ','2780000', to_date('15-05-2022', 'DD-MM-RRRR'),  null);
Insert into EXPENSE VALUES ('E005', 'NV003', 'Sửa sân SB01','1000000', to_date('16-04-2022', 'DD-MM-RRRR'),  null);
                                  