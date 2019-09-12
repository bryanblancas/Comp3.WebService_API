package TT_2018B003.Test_WebService.Repository.Interfaces;

import TT_2018B003.Test_WebService.Model.Entity.CertificateEntity;

public interface ICertificateRepository {
	public CertificateEntity getCertificateByIdUser(String idUser_User); 
	public CertificateEntity searchCertificate(String certificate);
	public int insertCertificate(String certificate, String idUser_User);
}
