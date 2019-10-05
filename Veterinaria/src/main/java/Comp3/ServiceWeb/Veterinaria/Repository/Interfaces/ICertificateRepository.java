package Comp3.ServiceWeb.Veterinaria.Repository.Interfaces;

import Comp3.ServiceWeb.Veterinaria.Model.Entity.CertificateEntity;

public interface ICertificateRepository {
	public CertificateEntity findCertificateById(String certificate);
	public CertificateEntity findCertificateByIdUser(String user_data_idUser);
	public int saveCertificate(CertificateEntity certificate);
	public int deleteCertificateByCert(String certificate);
}
