package be.swsb.ng2boot.smurf;

import org.springframework.data.jpa.repository.JpaRepository;

interface SmurfRepository extends JpaRepository<Smurf, Long> {
}
