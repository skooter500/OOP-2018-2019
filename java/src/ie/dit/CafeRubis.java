package ie.dit;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class CafeRubis extends PApplet
{
    ArrayList<Product> products = new ArrayList<Product>();
    
    public void settings()
    {
        size(800, 800);
        loadProducts();
    }

    void loadProducts()
    {
        Table table = loadTable("cafe.csv", "header");
        for(TableRow tr:table.rows())
        {
            Product p = new Product(tr);
            products.add(p);
        }        
    }

    public void mouseClicked()
    {
        int which = -1;

        // The best way!!
        if ((mouseX > border && mouseX < border + buttonWidth))
        {
            if ((mouseY - border) % (buttonHeight + gap) < buttonHeight)
            {
                which = (int) ((mouseY - border) / (buttonHeight + gap));
            }
        }

        
        // This also works
        /*
        if (mouseX > border && mouseX < border + buttonWidth)
        {
            for(int i = 0 ; i < products.size() ; i ++)
            {
                float y = border + (i * (buttonHeight + gap));
                if (mouseY > y && mouseY < y + buttonHeight)
                {
                    which = i;
                    break;
                }
            }
        }
        */
        if (which != -1)
        {
            System.out.println(products.get(which));
        }
    }

    float border = 20;
    float buttonWidth = 200;
    float buttonHeight = 50;
    float gap = 20;


    void drawProductButtons()
    {
        
        for(int i = 0 ; i < products.size() ; i ++)
        {
            Product p = products.get(i);
            float y = border + (i * (buttonHeight + gap));
            float x = border;
            noFill();
            stroke(0);
            rect(x, y, buttonWidth, buttonHeight);
            textAlign(CENTER, CENTER);
            fill(0);
            text(p.getName(),  x + buttonWidth * 0.5f, y + buttonHeight * 0.5f);
        }
    }

    public void draw()
    {
        background(127);
        drawProductButtons();
    }

}