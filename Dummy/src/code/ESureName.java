package code;
import java.util.Random;

public enum ESureName {
    Mia, Emma, Hannah, Anna, Lea, Leonie, Lina, Marie, Sofia, Lena, Emily, Lilli, Laura, Sophie, Lara, Amelie, Emilia, Nele, Johanna, Sarah, Luisa, Maja, Leni, Clara, Pia, Charlotte, Julia, Alina, Melina, Lisa, Zoe, Paula, Jana, Lia, Ida, Finja, Emely, Lotta, Greta, Josephine, Marlene, Mathilda, Jasmin, Frieda, Stella, Ella, Isabell, Victoria, Lucy, Helena, Katharina, Annika, Chiara, Mara, Isabella, Amy, Fiona, Antonia, Pauline, Mila, Jule, Maria, Nina, Elisa, Theresa, Franziska, Jolina, Selina, Eva, Celina, Merle, Mira, Milena, Melissa, Sina, Elena, Ronja, Vanessa, Carla, Luise, Helene, Nora, Romy, Angelina, Aylin, Carolin, Luna, Magdalena, Samira, Celine, Leila, Paulina, Carlotta, Linda, Larissa, Vivien, Valentina, Elisabeth, Jette, Kim, Zoey,
    
    Ben, Leon, Lukas, Finn, Jonas, Maximilian, Luis, Paul, Felix, Luca, Noah, Tim, Elias, Max, Julian, Philipp, Moritz, Niklas, Alexander, Jan, Jakob, Tom, David, Erik, Fabian, Simon, Jannik, Nico, Lennard, Linus, Oskar, Nils, Anton, Emil, Florian, Nick, Leo, Rafael, Vincent, Henry, Hannes, Benjamin, Adrian, Marlon, Mika, Joel, Jonathan, Till, Samuel, Daniel, Sebastian, Lennox, Dominic, Johannes, Jason, Colin, Leonard, Julius, Jannis, Aaron, Constantin, Tobias, Carl, Liam, Jona, Ole, Lenny, Matteo, Robin, Timo, Theo, John, Jayden, Johann, Levi, Mats, Bastian, Jamie, Mattis, Mohammed, Gabriel, Marc, Noel, Joshua, Phil, Lasse, Levin, Kilian, Maxim, Michael, Valentin, Justus, Benedikt, Damian, Tyler, Justin, Marvin, Malte, Matti, Artur;
    
    public static ESureName getRandomSurename() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
