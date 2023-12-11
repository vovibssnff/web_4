package com.vovi.backend_new.service;

import com.vovi.backend_new.entity.DotEntity;

public class DotService {
    public boolean check(DotEntity dot) {
        return dot.getX() >= 0 && dot.getX() <= dot.getR() && dot.getY() >= 0 && dot.getY() <= dot.getR() / 2 ||
                dot.getY() >= dot.getX() - 2 && dot.getX() >= 0 && dot.getY() <= 0 ||
                (long) dot.getX() * dot.getX() + dot.getY() * dot.getY() <= (long) dot.getR() * dot.getR() / 4;
    }
}
