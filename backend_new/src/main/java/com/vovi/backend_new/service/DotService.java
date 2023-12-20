package com.vovi.backend_new.service;

import com.vovi.backend_new.dto.DotDTO;

public class DotService {
    public boolean check(DotDTO dot) {
        return dot.getX() >= -dot.getR()/2 && dot.getY()<dot.getR() && dot.getX()<=0 && dot.getY()>=0  ||
                dot.getY() >= dot.getX() - dot.getR()/2 && dot.getX() >= 0 && dot.getY() <= 0 ||
                (dot.getX() * dot.getX() + dot.getY() * dot.getY() <= dot.getR() * dot.getR() / 4) && dot.getX()>=0 && dot.getY()>=0;
    }
}
